package models;

import enums.GameState;
import exceptions.InvalidGameDimension;
import exceptions.InvalidNumberOfPlayers;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Integer nextPlayerIndex;
    private Player winner;

    private Game() {}

    public static Builder getBuilder() {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public Player getWinner() {
        return winner;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayer() {
        return players;
    }
    public void setPlayer(List<Player> players) {
        this.players = players;
    }
    public List<Move> getMove() {
        return moves;
    }
    public void setMove(List<Move> moves) {
        this.moves = moves;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public Integer getNextPlayerIndex() {
        return nextPlayerIndex;
    }
    public void setNextPlayerIndex(Integer nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }


    public void displayBoard() {
        this.board.displayBoard();
    }

//    We will use builder pattern to build the game
    public static class Builder {
    private Integer dimension;
    private List<Player> players;

    public Builder setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }
    public Builder setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    private void isValid() throws InvalidGameDimension, InvalidNumberOfPlayers {
        if (dimension < 3) {
            throw new InvalidGameDimension("The dimension: " + dimension + " is not valid. Try value greater than 3");
        }
        if (players == null || players.size() != dimension - 1) {
            throw new InvalidNumberOfPlayers("Players are either null or more than the capacity of the game");
        }
    }
    public Game build() {
//        Before building the game, we should validate

        try {
            isValid();
        }
        catch (InvalidNumberOfPlayers | InvalidGameDimension e) {
            System.out.println("Game can't be built because of the following error: " + e.getMessage());
            return null;
        }
        Game game = new Game();
        game.setGameState(GameState.IN_PROGRESS);
        game.setPlayer(players);
        game.setBoard(new Board(dimension));
        game.setMove(new ArrayList<>());
        game.setNextPlayerIndex(0);

        return game;
    }
}
}
