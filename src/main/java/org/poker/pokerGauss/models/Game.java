package org.poker.pokerGauss.models;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.poker.pokerGauss.services.WinnerSelector;
import org.poker.pokerGauss.services.gamebuilders.DefaultGameBuilder;
import org.poker.pokerGauss.services.GameBuilder;
import org.poker.pokerGauss.services.winnerselectors.DefaultWinnerSelector;
import org.poker.pokerGauss.utils.exceptions.IncorrectNumberOfPlayersException;

public class Game {

    private final AtomicLong playerIdCounter = new AtomicLong();
    private final long numberOfPlayers;
    private Player winner;
    private List<Player> players;
    private String gameWinningPlay;

    // utilizamos el constructor de partidas por defecto
    private final GameBuilder builder = new DefaultGameBuilder(this);
    // utilizamos el decididor de ganador por defecto
    private final WinnerSelector winnerSelector = new DefaultWinnerSelector(this);

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

    public void selectWinner() {
        this.winner = winnerSelector.selectWinner();
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

    public String getGameWinningPlay() {
        return gameWinningPlay;
    }

    public void setGameWinningPlay(String gameWinningPlay) {
        this.gameWinningPlay = gameWinningPlay;
    }
}
