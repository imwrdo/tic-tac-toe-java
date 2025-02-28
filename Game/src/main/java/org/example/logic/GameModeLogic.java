package org.example.logic;

import org.example.enums.Character;
import org.example.players.ComputerPlayer;
import org.example.players.Player;
import org.example.players.PlayerCreator;

import java.util.Scanner;

public class GameModeLogic {
    private static final Scanner SCANNER = new Scanner(System.in);

    // Game logic
    private void playGame(Player firstPlayer, Player secondPlayer, boolean isFirstPlayerTurn) {
        Game game = new Game();
        while (true) {
            Game.drawBoard(game.getBoard());
            Player currentPlayer = isFirstPlayerTurn
                    ? firstPlayer
                    : secondPlayer;
            System.out.println("Player %d's turn (%s)".formatted(currentPlayer.getId(), currentPlayer.getCharacter()));


            int position = currentPlayer instanceof ComputerPlayer
                    ? ((ComputerPlayer) currentPlayer).getBestMove(game)
                    : getUserMove();

            if (!game.registerMove(position, currentPlayer.getCharacter())) {
                System.out.println("You did invalid move");
                continue;
            }
            if (game.checkWin()) {
                Game.drawBoard(game.getBoard());
                System.out.println("Player %d's (%s) wins!".formatted(currentPlayer.getId(), currentPlayer.getCharacter()));
                break;
            }
            if (game.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
            isFirstPlayerTurn = !isFirstPlayerTurn;

        }
    }

    // Human move
    private int getUserMove() {
        System.out.println("Enter position (1-9):");

        while (true) {
            try {
                int position = Integer.parseInt(SCANNER.nextLine());
                validatePosition(position);
                return position-1;
            } catch (NumberFormatException e) {
                System.out.println("Position must be a number!");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePosition(int position) {
        if (position < 1 || position > 9) {
            throw new IllegalArgumentException("Invalid position! Please enter a number between 1 and 9.");
        }
    }

    // Human vs Human
    public void beginDuoGame() {
        System.out.println("Welcome to the game with another player!\n");

        PlayerCreator playerCreator = new PlayerCreator();
        Player firstPlayer = null;
        do {
            firstPlayer = playerCreator.createPlayer(1);
        }while(firstPlayer == null);

        Character secondPlayerChar = firstPlayer.getCharacterEnum() == Character.X
                ? Character.O
                : Character.X;
        Player secondPlayer = new Player(2, secondPlayerChar);
        boolean isFirstPlayerTurn = true;
        playGame(firstPlayer, secondPlayer, isFirstPlayerTurn);

        System.out.println("\nGame Over!");
    }

    // Human vs Computer
    public void beginSingleGame() {
        System.out.println("Welcome to the Single game!\n");

        PlayerCreator playerCreator = new PlayerCreator();
        Player player = null;
        do {
            player = playerCreator.createPlayer(1);
        }while(player == null);

        Character computerChar = player.getCharacterEnum() == Character.X ? Character.O : Character.X;
        ComputerPlayer computer = new ComputerPlayer(2, computerChar);
        boolean isPlayerTurn = true;
        playGame(player, computer, isPlayerTurn);

        System.out.println("\nGame Over!");
    }
}

