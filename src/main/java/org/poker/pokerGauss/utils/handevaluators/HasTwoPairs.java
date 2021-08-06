package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

import java.util.HashMap;

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
        HashMap<Integer, Integer> hashmap = HandEvaluator.digestNumbersToHashMap(player.getHand());
        int hasAPair = 0;
        for (Integer value : hashmap.values()) {
            if (value == 2) {
                hasAPair += 1;
            }
        }
        return hasAPair == 2;
    }
}