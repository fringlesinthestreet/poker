package org.poker.pokerGauss.services.gamebuilders;

import org.poker.pokerGauss.models.Card;
import org.poker.pokerGauss.models.Game;
import org.poker.pokerGauss.services.DeckGenerator;
import org.poker.pokerGauss.services.GameBuilder;
import org.poker.pokerGauss.services.deckgenerators.DefaultDeckGenerator;

import java.util.ArrayList;
import java.util.Collections;

public class DefaultGameBuilder implements GameBuilder {
    private final Game game;
    private final DeckGenerator deckGenerator = new DefaultDeckGenerator();
    private static final int HAND_SIZE = 5;

    public DefaultGameBuilder(Game game) {
        this.game = game;
    }

    public void buildGame() {
        ArrayList<Card> deck = deckGenerator.generateDeck();
        ArrayList<Card> hand = new ArrayList<Card>();

        int current_hand_size = 0;
        int current_number_of_players = 0;
        for (Card card : deck) {

            hand.add(card);
            current_hand_size += 1;

            if (current_hand_size == HAND_SIZE){
                // Ordenamos la mano para visualizarla más fácil
                Collections.sort(hand, Collections.reverseOrder());

                // Guardamos la mano del jugador
                game.addPlayer(hand);

                // Nos preparamos para asignar otra mano
                hand = new ArrayList<Card>();
                current_hand_size = 0;
                current_number_of_players += 1;
            }

            // Si ya se llegó al número de jugadores definido, se termina
            if (current_number_of_players == game.getNumberOfPlayers()) {
                break;
            }
        }
    }
}
