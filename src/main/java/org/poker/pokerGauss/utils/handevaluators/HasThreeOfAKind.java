package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

import java.util.HashMap;

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
        HashMap<Integer, Integer> hashmap = HandEvaluator.digestNumbersToHashMap(player.getHand());
        boolean hasThreeOfAKind = false;
        for (Integer value : hashmap.values()) {
            if (value == 3) {
                hasThreeOfAKind = true;
            }
        }
        return hasThreeOfAKind;
    }
}