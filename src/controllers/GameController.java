package controllers;

import enums.GameState;
import models.Game;
import models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimensions, List<Player> players) {
        return Game.getBuilder().setDimension(dimensions).setPlayers(players).build();
    }

    public void undo(Game game) {

    }

    public void  executeNextMove(Game game) {

    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void displayBoard(Game game) {

    }
}
