package org.poker.pokerGauss.controllers.v1.games;

import org.poker.pokerGauss.controllers.v1.V1Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.poker.pokerGauss.models.Game;

@RestController
public class NewGameController extends V1Controller {

    @GetMapping("/newgame")
    public Game newGame(@RequestParam(value = "players") long numberOfPlayers){
        Game game = new Game(numberOfPlayers);
        game.buildGame();

        return game;
    }
}
