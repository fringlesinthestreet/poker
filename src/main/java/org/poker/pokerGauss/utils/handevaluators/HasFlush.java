package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasFlush  extends HandEvaluator {

    @Override
    public String getName() {
        return "Flush";
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return true;
    }
}