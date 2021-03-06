package org.poker.pokerGauss.services.winnerselectors;

import org.poker.pokerGauss.models.Card;
import org.poker.pokerGauss.models.Game;
import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.services.WinnerSelector;
import org.poker.pokerGauss.utils.HandEvaluator;
import org.poker.pokerGauss.utils.MyRange;
import org.poker.pokerGauss.utils.handevaluators.HasStraight;
import org.poker.pokerGauss.utils.handevaluators.HasStraightFlush;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DefaultWinnerSelector implements WinnerSelector {
    private final Game game;
    private final ArrayList<HandEvaluator> posibleHands = HandEvaluator.getPosibleHands();
    private static final int HAND_SIZE = 5;

    public DefaultWinnerSelector(Game game) {
        this.game = game;
    }

    public Player selectWinner() {
        ArrayList<Player> posibleWinners = new ArrayList<>();

        // Ordenamos las posibles manos por prioridad (defecto)
        Collections.sort(posibleHands, Comparator.comparing(s -> s.getPriority()));

        for (HandEvaluator evaluator : posibleHands) {
            /*
            Iteramos sobre las posibles manos para verificar
            si algún jugador posee la combinación necesaria.

            Vamos de mejor mano a peor mano y seleccionamos
            aquellos jugadores que sí la poseen.
            */

            for (Player current_player : game.getPlayers()) {
                /*
                Vamos uno a uno con los jugadores verificándolo.
                */
                if (evaluator.hasThisPokerHand(current_player)){
                    posibleWinners.add(current_player);
                }
            }

            /*
            Si a esta altura se tiene al menos un jugador en
            la lista, entonces no se debe seguir revisando
            las distintas combinaciones posibles.
            */

            game.setGameWinningPlay(evaluator.getName());
            game.gameWinningEvaluatorSetter(evaluator);
            if (posibleWinners.size() > 0) {
                break;
            }
        }


        // De base ponemos al primero como actual vencedor.
        Player current_winner = posibleWinners.get(0);

        /*
        Se debe revisar si más de un jugador tuvo esa misma
        mano. En ese caso, se debe elegir por carta mayor.
        */

        if (posibleWinners.size() > 1) {
            // Se tiene un caso borde en este caso, que es con la escala
            if (game.gameWinningEvaluatorGetter().getClass() == HasStraight.class || game.gameWinningEvaluatorGetter().getClass() == HasStraightFlush.class){
                posibleWinners = getBorderCaseBreaker(posibleWinners);
            }

            posibleWinners = getFirstTieBreaker(posibleWinners);
            current_winner = posibleWinners.get(0);
        }

        // En caso de que dos jugadores tengan los mismos números
        if (posibleWinners.size() > 1) {
            current_winner = getSecondTieBreaker(posibleWinners);
        }

        return current_winner;
    }

    /*
        Se revisa el caso borde de que la escala sea A 5 4 3 2 (que es la peor).

        Se dejan en una lista (tieBreakerWinners) los jugadores que no poseen
        esa escala. Si al finalizar de chequear, no hay nadie en esa lista,
        entonces significa que todos tienen el caso borde y se envía la lista
        original. En caso contrario, se envía la lista de los que no poseen esa
        mano, es decir, la lista tieBreakerWinners.
     */
    private ArrayList<Player> getBorderCaseBreaker(ArrayList<Player> posibleWinners) {
        int[] borderAux = {1, 5, 4, 3, 2};

        ArrayList<Player> tieBreakerWinners = new ArrayList<>();
        Card current_card;
        int current_border_card;
        MyRange positionRange = new MyRange(1, HAND_SIZE);
        for (int current_position : positionRange) {
            current_border_card = borderAux[current_position];

            // Primero debemos elegir la carta más alta por ronda.
            for (Player current_player : posibleWinners){
                current_card = getCardFromHand(current_player, current_position);

                if (tieBreakerWinners.contains(current_player)){
                    continue;
                }

                if (current_border_card != current_card.getNumber()){
                    tieBreakerWinners.add(current_player);
                }
            }
        }
        if (tieBreakerWinners.size() > 0){
            return tieBreakerWinners;
        }
        return posibleWinners;
    }

    /*
        En este primer desempate se define solo por número. El que tiene
        un número superior a todos los otros gana.
        Puede quedar más de un jugador como posible ganador luego de este desempate.
     */
    private ArrayList<Player> getFirstTieBreaker(ArrayList<Player> posibleWinners) {
        ArrayList<Player> tieBreakerWinners;
        Card current_card;
        Card current_biggest_card;
        int current_biggest_number;
        MyRange positionRange = new MyRange(0, HAND_SIZE);
        for (int current_position : positionRange) {
            current_biggest_card = null;

            // Primero debemos elegir la carta más alta por ronda.
            for (Player current_player : posibleWinners){
                current_card = getCardFromHand(current_player, current_position);
                if (current_biggest_card == null){
                    current_biggest_card = current_card;
                }

                if (current_card.compareTo(current_biggest_card) > 0) {
                    current_biggest_card = current_card;
                }
            }

            // Ahora vemos si más de uno posee ese mismo número
            tieBreakerWinners = new ArrayList<>();
            current_biggest_number = current_biggest_card.getNumber();
            for (Player current_player : posibleWinners) {
                current_card = getCardFromHand(current_player, current_position);
                if (current_card.getNumber() == current_biggest_number){
                    tieBreakerWinners.add(current_player);
                }
            }
            /*
                Asignamos el grupo reducido que pasó el desempate como
                el nuevo grupo de posibles ganadores.
            */
            posibleWinners = tieBreakerWinners;

            // En caso de que sea solo uno el ganador del desempate, terminamos.
            if (posibleWinners.size() == 1){
                break;
            }
        }
        return posibleWinners;
    }

    /*
        Este desempate se define por la carta más alta de ambos jugadores.
        El que tiene la pinta más alta, gana.
     */
    private Player getSecondTieBreaker(ArrayList<Player> posibleWinners){
        // De base ponemos al primero como actual vencedor.
        Player current_winner = posibleWinners.get(0);
        Card current_card;
        Card current_biggest_card;
        current_biggest_card = null;
        for (Player current_player : posibleWinners) {
            current_card = getCardFromHand(current_player, 0);
            if (current_biggest_card == null) {
                current_biggest_card = current_card;
            }

            if (current_card.compareTo(current_biggest_card) > 0) {
                current_biggest_card = current_card;
                current_winner = current_player;
            }
        }
        return current_winner;
    }

    private Card getCardFromHand(Player player, int position){
        return player.getHand().get(position);
    }
}
