package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

import java.util.HashMap;

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
        HashMap<Integer, Integer> hashmap = HandEvaluator.digestNumbersToHashMap(player.getHand());
        boolean hasFourOfAKind = false;
        for (Integer value : hashmap.values()) {
            if (value == 4) {
                hasFourOfAKind = true;
            }
        }
        return hasFourOfAKind;
    }
}