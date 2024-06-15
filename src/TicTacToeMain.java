import controllers.GameController;
import enums.BotDifficultyLevel;
import enums.GameState;
import enums.PlayerType;
import models.Bot;
import models.Game;
import models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class TicTacToeMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Game is Starting...");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the dimensions: ");
        System.out.println();
        int dimensions = scanner.nextInt();

        System.out.print("Will there be any bot? Y/N: ");
        String answer = scanner.next();

        List<Player> players = new ArrayList<>();
        int numberOfHumanPlayers = dimensions - 1;
        if (answer.equalsIgnoreCase("Y")) {
            numberOfHumanPlayers--;
            players.add(new Bot("Random Bot", 'X', BotDifficultyLevel.EASY));
        }

        for (int i = 0; i < numberOfHumanPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            System.out.println();
            String playerName = scanner.next();
            System.out.print("Enter player " + (i + 1) + " symbol: ");
            System.out.println();
            Character playerSymbol = scanner.next().charAt(0);
            Player player = new Player(playerName, playerSymbol, PlayerType.HUMAN);
            players.add(player);
        }

        GameController gameController = new GameController();
        Game game = gameController.createGame(dimensions, players);

        while (gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {
//            players will play the game till the game is in progress state
            System.out.println("Game is In Progress...");
            sleep(5000);
        }

//        If the game is ended or draw
        if (gameController.getGameState(game).equals(GameState.DRAW)) {
            System.out.println("Game is Draw!");
        }

        if (gameController.getGameState(game).equals(GameState.ENDED)) {
//            Someone won the game
            Player player = gameController.getWinner(game);
            System.out.println("Winner is " + player.getName());
        }
    }
}