package org.poker.pokerGauss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.poker.pokerGauss.models.Player;
import org.poker.pokerGauss.models.Card;

@RestController
public class NewGameController {

    @GetMapping("/newgame")
    public Card card(){


        List<Card> hand = new ArrayList();

        Card card1 = new Card(1, "s");
        Card card2 = new Card(2, "s");
        Card card3 = new Card(3, "s");
        Card card4 = new Card(4, "s");
        Card card5 = new Card(5, "s");

        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        return card1;
    }
}
