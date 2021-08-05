package org.poker.pokerGauss.models;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.poker.pokerGauss.models.Card;


public class Player {

    private List<Card> hand;
    private long playerId;

    public Player(List<Card> hand, long playerId) {
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
