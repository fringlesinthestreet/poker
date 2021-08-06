package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasTwoPairs extends HandEvaluator {

    @Override
    public String getName() {
        return "Two Pairs";
    }

    @Override
    public int getPriority() {
        return 7;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return true;
    }
}