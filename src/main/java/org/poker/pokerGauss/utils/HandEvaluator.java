package org.poker.pokerGauss.utils;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.handevaluators.*;

import java.util.ArrayList;

public abstract class HandEvaluator {
    public abstract boolean hasThisPokerHand(Player player);

    public abstract String getName();

    public abstract int getPriority();

    public static ArrayList<HandEvaluator> getPosibleHands() {
        ArrayList<HandEvaluator> posibleHands = new ArrayList<>();
        posibleHands.add(new HasStraightFlush());
        posibleHands.add(new HasFourOfAKind());
        posibleHands.add(new HasFullHouse());
        posibleHands.add(new HasFlush());
        posibleHands.add(new HasStraight());
        posibleHands.add(new HasThreeOfAKind());
        posibleHands.add(new HasTwoPairs());
        posibleHands.add(new HasOnePair());
        posibleHands.add(new HasHighCard());

        return posibleHands;
    }


}
