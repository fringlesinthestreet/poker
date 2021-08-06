package org.poker.pokerGauss.services;

import org.poker.pokerGauss.models.Game;
import org.poker.pokerGauss.models.Player;

public interface WinnerSelector {

    public Player selectWinner();
}
