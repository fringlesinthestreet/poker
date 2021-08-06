package org.poker.pokerGauss.services.implementation;

import org.poker.pokerGauss.models.Game;
import org.poker.pokerGauss.services.GameBuilder;

public class DefaultGameBuilder implements GameBuilder {
    private final Game game;

    public DefaultGameBuilder(Game game) {
        this.game = game;
    }
}
