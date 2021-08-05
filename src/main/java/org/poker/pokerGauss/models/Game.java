package org.poker.pokerGauss.models;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

public class Game {

    private final AtomicLong playerIdCounter = new AtomicLong();
    private final long numberOfPlayers;
    private Player winner;
    private List<Player> players;

    public Game(long numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
