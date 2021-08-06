package org.poker.pokerGauss.services;

import org.poker.pokerGauss.models.Card;

import java.util.ArrayList;
import java.util.stream.Stream;

public interface DeckGenerator {
    public ArrayList<Card> generateDeck();
}
