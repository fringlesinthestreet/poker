package org.poker.pokerGauss.models;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import org.poker.pokerGauss.services.implementation.DefaultGameBuilder;
import org.poker.pokerGauss.services.GameBuilder;
import org.poker.pokerGauss.utils.exceptions.IncorrectNumberOfPlayersException;

public class Game {

    private final AtomicLong playerIdCounter = new AtomicLong();
    private final long numberOfPlayers;
    private Player winner;
    private List<Player> players;

    // utilizamos el constructor de partidas por defecto
    private final GameBuilder builder = new DefaultGameBuilder(this);

    public Game(long numberOfPlayers) {
        if (1 > numberOfPlayers || numberOfPlayers > 10){
            throw new IncorrectNumberOfPlayersException();
        }
        this.numberOfPlayers = numberOfPlayers;
        this.players = new ArrayList<>();
    }

    public void buildGame() {
        builder.buildGame();
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

    public void addPlayer(List<Card> hand){
        this.players.add(new Player(hand, playerIdCounter.getAndIncrement()));
    }

    public long getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
