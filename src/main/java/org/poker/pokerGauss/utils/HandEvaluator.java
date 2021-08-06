package org.poker.pokerGauss.utils;

import org.poker.pokerGauss.models.Card;
import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.utils.handevaluators.*;

import java.util.*;

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

    public static boolean hasFlush (List<Card> hand) {
        Set<String> hashSet = new HashSet<>();
        for (Card card : hand) {
            hashSet.add(card.getSuit());
        }
        return hashSet.size() == 1;
    }

    public static boolean hasStraight (List<Card> hand) {
        // caso borde A K Q J 10
        boolean border = true;
        int[] borderAux = {1, 13, 12, 11, 10};
        int i = 0;

        Set<Integer> hashSet = new HashSet<>();
        for (Card card : hand) {
            hashSet.add(card.getNumber());

            // verificamos si se cumple el caso borde
            if (borderAux[i] != card.getNumber()){
                border = false;
            }
        }

        // en caso de que se cumplió, se retorna
        if (border){
            return true;
        }

        int min = 14;
        int max = -1;
        for (int cardNumber : hashSet) {
            if (min > cardNumber){
                min = cardNumber;
            }
            if (max < cardNumber) {
                max = cardNumber;
            }
        }
        /*
            Se tiene una escalera si la diferencia entre el mayor y el menor
            es 4 y si se tienen 5 números distintos en el set.
         */
        return ((max - min) == 4) && hashSet.size() == 5;

    }

    // Para saber si hay pares, trios, etc, agrupamos los números en un hashmap
    public static HashMap<Integer, Integer> digestNumbersToHashMap (List<Card> hand) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int number;
        int current_amount;
        for (Card card : hand) {
            number = card.getNumber();
            if (!hashMap.containsKey(number)) {
                hashMap.put(number, 1);
            } else {
                current_amount = hashMap.get(number);
                hashMap.put(number, current_amount + 1);
            }
        }
        return hashMap;
    }

}
