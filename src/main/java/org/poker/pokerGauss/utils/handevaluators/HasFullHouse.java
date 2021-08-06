package org.poker.pokerGauss.utils.handevaluators;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.HandEvaluator;

import java.util.HashMap;

public class HasFullHouse  extends HandEvaluator {

    @Override
    public String getName() {
        return "Full House";
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean hasThisPokerHand(Player player){
        HashMap<Integer, Integer> hashmap = HandEvaluator.digestNumbersToHashMap(player.getHand());
        boolean hasThreeOfAKind = false;
        boolean HasOnePair = false;
        for (Integer value : hashmap.values()) {
            if (value == 3) {
                hasThreeOfAKind = true;
            }
            if (value == 2) {
                HasOnePair = true;
            }
        }
        return hasThreeOfAKind && HasOnePair;
    }
}