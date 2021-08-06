package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasOnePair extends HandEvaluator {

    @Override
    public String getName() {
        return "One Pair";
    }

    @Override
    public int getPriority() {
        return 8;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return true;
    }
}