package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasThreeOfAKind extends HandEvaluator {

    @Override
    public String getName() {
        return "Three Of A Kind";
    }

    @Override
    public int getPriority() {
        return 6;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return true;
    }
}