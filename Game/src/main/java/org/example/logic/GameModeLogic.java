package org.example.logic;

import org.example.players.ComputerPlayer;
import org.example.players.Player;
import org.example.players.PlayerCreator;

import java.util.Scanner;

public class GameModeLogic {
    private static final Scanner scanner = new Scanner(System.in);

    // Game logic
    private void playGame(Player firstPlayer, Player secondPlayer, boolean isFirstPlayerTurn) {
        Game game = new Game();
        while (true) {
            Game.drawBoard(game.getBoard());
            Player currentPlayer = isFirstPlayerTurn ? firstPlayer : secondPlayer;
            System.out.println("Player " + currentPlayer.getId() + "'s turn (" + currentPlayer.getCharacter() + ")");

            int position = currentPlayer instanceof ComputerPlayer ?
                    ((ComputerPlayer) currentPlayer).getBestMove(game):getUserMove();

            if (!game.registerMove(position,currentPlayer.getCharacter())){
                System.out.println("You did invalid move");
                continue;
            }
            if (game.checkWin()) {
                Game.drawBoard(game.getBoard());
                System.out.println("Player "+ currentPlayer.getId()+" ("+currentPlayer.getCharacter()+")"+ " wins!");
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
                int position = Integer.parseInt(scanner.nextLine());

                if (position >= 1 && position <= 9){
                    return position - 1;
                }

                System.out.println("Invalid position! Enter a number between 1 and 9.");
            }catch (NumberFormatException e){
                System.out.println("Position must be a number!");
            }
        }
    }

    // Human vs Human
    public void beginDuoGame(){
        System.out.println("Welcome to the game with another player!\n");

        PlayerCreator playerCreator = new PlayerCreator();
        Player firstPlayer = playerCreator.createPlayer(1);
        if (firstPlayer == null) {
            System.out.println("Invalid character choice.");
            return;
        }
        Player secondPlayer = new Player(2,firstPlayer.getCharacter().equals("X")?"0":"X");
        boolean isFirstPlayerTurn = true;
        playGame(firstPlayer,secondPlayer,isFirstPlayerTurn);

        System.out.println("\nGame Over!");
    }

    // Human vs Computer
    public void beginSingleGame() {
        System.out.println("Welcome to the Single game!\n");

        PlayerCreator playerCreator = new PlayerCreator();
        Player player = playerCreator.createPlayer(1);
        if (player == null) {
            System.out.println("Invalid character choice. Returning to main menu.");
            return;
        }

        ComputerPlayer computer = new ComputerPlayer(2, player.getCharacter().equals("X") ? "O" : "X");
        Game game = new Game();
        boolean isPlayerTurn = true;
        playGame(player,computer,isPlayerTurn);

        System.out.println("\nGame Over!");
    }
}

