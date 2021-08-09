package org.poker.pokerGauss.models;

import java.util.Collections;
import java.util.List;

public class Player {

    private List<Card> hand;
    private long playerId;

    public Player(List<Card> hand, long playerId) {
        // Ordenamos la mano para visualizarla más fácil
        Collections.sort(hand, Collections.reverseOrder());
        this.hand = hand;
        this.playerId = playerId;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
