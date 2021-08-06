package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasFullHouse  extends HandEvaluator {

    @Override
    public String getName() {
        return "Full House";
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return true;
    }
}