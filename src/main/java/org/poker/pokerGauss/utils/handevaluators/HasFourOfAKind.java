package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasFourOfAKind  extends HandEvaluator {

    @Override
    public String getName() {
        return "Four Of A Kind";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return true;
    }
}