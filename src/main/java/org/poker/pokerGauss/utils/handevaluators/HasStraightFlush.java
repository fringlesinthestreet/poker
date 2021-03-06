package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

public class HasStraightFlush  extends HandEvaluator {

    @Override
    public String getName() {
        return "Straight Flush";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        return HandEvaluator.hasStraight(player.getHand()) && HandEvaluator.hasFlush(player.getHand());    }
}