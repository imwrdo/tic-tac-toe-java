package org.example;

import java.util.Scanner;

public class GameMenu {
    public void beginGame(){
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Tic-Tac-Toe game!\n");
        while (isRunning){
            System.out.println("Menu:");
            System.out.println("Please select game mode:");
            System.out.println("1 - Human vs. Human\n2 - Human vs. Computer\n3 - Exit");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        beginDuoGame();
                        break;
                    case 2:
                        beginSingleGame();
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Your choice must be a number between 1 and 3!");
                continue;
            }

        }
    }
    
    public Player playerChoice(String choice){
        Player player = null;
        switch (choice){
            case "X":
                player = new Player(1,"X");
                break;
            case "O":
                player = new Player(1,"O");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        return player;
    }

    public void beginDuoGame(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Single game!\n");
        System.out.println("First player,please select your character (X or O):");
        String choice = scanner.nextLine();
        Player firstPlayer = playerChoice(choice);
        Player secondPlayer = new Player(2, firstPlayer.getCharacter().equals("X") ? "O" : "X");

        Game game = new Game();
        boolean isFirstPlayerTurn = true;
        
        while (true) {
            Game.drawBoard(game.getBoard());
            Player currentPlayer = isFirstPlayerTurn ? firstPlayer : secondPlayer;
            System.out.println(currentPlayer);
            System.out.println("Player " + currentPlayer.getId() + "'s turn (" + currentPlayer.getCharacter() + ")");
            System.out.println("Enter position (1-9):");

            try{
                int position = Integer.parseInt(scanner.nextLine()) - 1;
                if (game.makeMove(position, currentPlayer.getCharacter())) {
                    if (game.checkWin()) {
                        Game.drawBoard(game.getBoard());
                        System.out.println("Player " + currentPlayer.getId() + " wins!");
                        break;
                    }
                    if (game.isBoardFull()) {
                        Game.drawBoard(game.getBoard());
                        System.out.println("It's a draw!");
                        break;
                    }
                    isFirstPlayerTurn = !isFirstPlayerTurn;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }catch (NumberFormatException e){
                System.out.println("Position must be a number!");
                continue;
            }

            

        }
    }

    public void beginSingleGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Single game!\n:");
        System.out.println("Please select your character (X or O):");
        String choice = scanner.nextLine();
        Player player = playerChoice(choice);
        
        if (player == null) {
            System.out.println("Invalid character choice. Returning to main menu.");
            return;
        }

        ComputerPlayer computer = new ComputerPlayer(2, player.getCharacter().equals("X") ? "O" : "X");
        Game game = new Game();
        boolean isPlayerTurn = true;
        
        while (true) {
            Game.drawBoard(game.getBoard());
            
            if (isPlayerTurn) {
                System.out.println("Your turn (" + player.getCharacter() + ")");
                System.out.println("Enter position (1-9):");
                
                try {
                    int position = Integer.parseInt(scanner.nextLine()) - 1;
                    if (position < 0 || position > 8) {
                        System.out.println("Position must be between 1 and 9!");
                        continue;
                    }
                    
                    if (!game.makeMove(position, player.getCharacter())) {
                        System.out.println("Invalid move! Position already taken.");
                        continue;
                    }
                    
                    Game.drawBoard(game.getBoard());
                    if (game.checkWin()) {
                        System.out.println("You win!");
                        break;
                    }
                    if (game.isBoardFull()) {
                        System.out.println("It's a draw!");
                        break;
                    }
                    isPlayerTurn = false;
                    
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                    continue;
                }
            } else {
                System.out.println("\nComputer's turn (" + computer.getCharacter() + ")");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                int position = computer.getBestMove(game);
                game.makeMove(position, computer.getCharacter());
                System.out.println("Computer chose position: " + (position + 1)+"\n");
                
                Game.drawBoard(game.getBoard());
                if (game.checkWin()) {
                    System.out.println("Computer wins!");
                    break;
                }
                if (game.isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                isPlayerTurn = true;
            }
        }
        
        System.out.println("\nGame Over!");
    }
}
