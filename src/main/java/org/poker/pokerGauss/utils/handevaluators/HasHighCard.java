package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasHighCard extends HandEvaluator {

    @Override
    public String getName() {
        return "High Card";
    }

    @Override
    public int getPriority() {
        return 9;
    }

    // Por defecto todos tienen esta mano
    @Override
    public boolean hasThisPokerHand(Player player){
        return true;
    }
}
