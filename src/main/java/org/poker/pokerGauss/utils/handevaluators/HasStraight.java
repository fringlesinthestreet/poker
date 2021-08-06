package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasStraight  extends HandEvaluator {

    @Override
    public String getName() {
        return "Straight";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return HandEvaluator.hasStraight(player.getHand());
    }
}