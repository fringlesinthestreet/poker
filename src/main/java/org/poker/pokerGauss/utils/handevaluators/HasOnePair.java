package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

import java.util.HashMap;

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
        HashMap<Integer, Integer> hashmap = HandEvaluator.digestNumbersToHashMap(player.getHand());
        boolean HasOnePair = false;
        for (Integer value : hashmap.values()) {
            if (value == 2) {
                HasOnePair = true;
            }
        }
        return HasOnePair;
    }
}