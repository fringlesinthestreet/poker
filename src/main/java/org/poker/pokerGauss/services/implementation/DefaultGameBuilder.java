package org.poker.pokerGauss.services.implementation;

import org.poker.pokerGauss.models.Card;
import org.poker.pokerGauss.models.Game;
import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.services.DeckGenerator;
import org.poker.pokerGauss.services.GameBuilder;

import java.util.ArrayList;
import java.util.stream.Stream;

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
                game.addPlayer(hand);
                hand = new ArrayList<Card>();
                current_hand_size = 0;
                current_number_of_players += 1;
            }

            if (current_number_of_players == game.getNumberOfPlayers()) {
                break;
            }
        }
    }
}
