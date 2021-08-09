package org.poker.pokerGauss.models;

import org.poker.pokerGauss.utils.ComparisonUtils;

public class Card implements Comparable<Card> {

    private final int number;
    private final String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }

    /*
        Se hace override este método para que sea ordenable un array de Cards
     */
    public int compareTo (Card c){
        if (number == c.number){
            if (ComparisonUtils.isASuperiorSuit(suit, c.suit)){
                return 1;
            };
        }
        if (ComparisonUtils.isASuperiorNumber(number, c.number)){
            return 1;
        }
        return -1;
    }
}
