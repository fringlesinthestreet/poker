package org.poker.pokerGauss.services.implementation;

import org.poker.pokerGauss.models.Card;
import org.poker.pokerGauss.services.DeckGenerator;
import org.poker.pokerGauss.utils.MyRange;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class DefaultDeckGenerator implements DeckGenerator {

    public static final int LOWEST_CARD = 1;
    public static final int HIGHEST_CARD = 13;
    public static final String[] SUITS = {"s", "h", "c", "d"};

    public Stream generateDeck() {
        ArrayList<Card> cardArray = new ArrayList<>();
        MyRange cardRange = new MyRange(LOWEST_CARD, HIGHEST_CARD);
        for (int number : cardRange) {
            for (String suit : SUITS) {
                cardArray.add(new Card(number, suit));
            }
        }
        Collections.sort(cardArray);
        return Stream.of(cardArray);
    }
}