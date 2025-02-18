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
        System.out.println("Welcome to the Single game!\n:");
        System.out.println("First player,please select your character (X or O):");
        String choice = scanner.nextLine();
        Player firstPlayer = playerChoice(choice);
        Player secondPlayer = null;
        if(firstPlayer!=null && firstPlayer.getCharacter().equals("X")){
            secondPlayer = new Player(1,"O");
        }else{
            secondPlayer = new Player(1,"X");
        }

        Game game = new Game();
        boolean isFirstPlayerTurn = true;
        
        while (true) {
            Game.drawBoard(game.getBoard());
            Player currentPlayer = isFirstPlayerTurn ? firstPlayer : secondPlayer;

            assert currentPlayer != null;
            System.out.println("Player " + currentPlayer.id + "'s turn (" + currentPlayer.getCharacter() + ")");
            System.out.println("Enter position (1-9):");
            int position = Integer.parseInt(scanner.nextLine()) - 1;
            
            if (game.makeMove(position, currentPlayer.getCharacter())) {
                if (game.checkWin()) {
                    Game.drawBoard(game.getBoard());
                    System.out.println("Player " + currentPlayer.id + " wins!");
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
        }
    }

    public void beginSingleGame(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Single game!\n:");
        System.out.println("Please select your character (X or O):");
        String choice = scanner.nextLine();
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

        assert player != null;
        Player computer = new Player(2, player.getCharacter().equals("X") ? "O" : "X");
        Game game = new Game();
        boolean isPlayerTurn = true;
        
        while (true) {
            Game.drawBoard(game.getBoard());
            
            if (isPlayerTurn) {
                System.out.println("Your turn (" + player.getCharacter() + ")");
                System.out.println("Enter position (1-9):");
                int position = Integer.parseInt(scanner.nextLine()) - 1;
                
                if (!game.makeMove(position, player.getCharacter())) {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }
            } else {
                System.out.println("Computer's turn (" + computer.getCharacter() + ")");
                // TODO: Computer logic
            }
            
            Player currentPlayer = isPlayerTurn ? player : computer;
            if (game.checkWin()) {
                Game.drawBoard(game.getBoard());
                System.out.println((isPlayerTurn ? "You win!" : "Computer wins!"));
                break;
            }
            if (game.isBoardFull()) {
                Game.drawBoard(game.getBoard());
                System.out.println("It's a draw!");
                break;
            }
            isPlayerTurn = !isPlayerTurn;
        }
    }
}
