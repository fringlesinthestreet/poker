package org.poker.pokerGauss.models;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import org.poker.pokerGauss.services.implementation.DefaultGameBuilder;
import org.poker.pokerGauss.services.GameBuilder;

public class Game {

    private final AtomicLong playerIdCounter = new AtomicLong();
    private final long numberOfPlayers;
    private Player winner;
    private List<Player> players;

    // utilizamos el constructor de partidas por defecto
    private final GameBuilder builder = new DefaultGameBuilder(this);

    public Game(long numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void buildGame() {
        builder.build();
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

    public void addPlayer(Player player){
        this.players.add(player);
    }
}
