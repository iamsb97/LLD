package chess;

import java.util.Scanner;

public class ChessGame {
    private Player player1;
    private Player player2;
    private Board board;

    public ChessGame(User user1, User user2) {
        player1 = new Player(user1, Color.WHITE);
        player2 = new Player(user2, Color.BLACK);
        board = new Board();
    }

    private String[] validateInput(String input) {
        String[] coordStrings = input.split(":");
        
        if (coordStrings.length != 2) {
            System.err.println("Invalid input format! Try again.");
            return null;
        }
        
        int row = Integer.parseInt(coordStrings[0]);
        int col = Integer.parseInt(coordStrings[1]);
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            System.err.println("Invalid coordinates! Try again.");
            return null;
        }

        return coordStrings;
    }

    private Cell selectCell(Player p, String messageString) {
        System.out.println(p.getColor().toString() + messageString);
        System.out.println("Input format: i,j");
        
        int row, col;
        Scanner scan = new Scanner(System.in);
        while (true) {
            String line = scan.nextLine();
            
            String[] coordStrings;
            if ((coordStrings = validateInput(line)) == null) {
                continue;
            }
            row = Integer.parseInt(coordStrings[0]);
            col = Integer.parseInt(coordStrings[1]);

            break;
        }
        scan.close();

        return board.getCell(row, col);
    }

    private boolean isComplete() {
        return true;
    }
    
    public void start() {
        Player currentPlayer = this.player1;
        String sourceMessage = "'s turn: Please enter the coordinates of the piece you wish to move!";
        String targetMessage = "'s turn: Please enter the coordinates where you wish to place the piece!";

        while (!isComplete()) {
            Cell source = this.selectCell(currentPlayer, sourceMessage);
            if (source.getPiece() != null && source.getPiece().getColor() != currentPlayer.getColor()) {
                System.err.println("Selected coordinates do not contain your piece. Try again!");
                continue;
            }
            Cell target = this.selectCell(currentPlayer, targetMessage);
            if (target.getPiece() != null && target.getPiece().getColor() == currentPlayer.getColor()) {
                System.err.println("Selected coordinates contain your piece. Try again!");
                continue;
            }

            if (board.move(source, target)) {
                board.display();
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
    }

    public Player getWhitePlayer() {
        return this.player1;
    }

    public Player getBlackPlayer() {
        return this.player2;
    }
}