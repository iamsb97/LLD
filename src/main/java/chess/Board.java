package chess;

import chess.Pieces.*;

public class Board {
    private Cell[][] board = new Cell[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
        initializePlayerPieces(Color.WHITE);
        initializePlayerPieces(Color.BLACK);
    }

    private void initializePlayerPieces(Color c) {
        int row1, row2;
        if (c == Color.WHITE) {
            row1 = 0;
            row2 = 1;
        } else {
            row1 = 7;
            row2 = 6;
        }

        board[row1][0].setPiece(new Rook(c));
        board[row1][1].setPiece(new Horse(c));
        board[row1][2].setPiece(new Bishop(c));
        board[row1][3].setPiece(new Queen(c));
        board[row1][4].setPiece(new King(c));
        board[row1][5].setPiece(new Bishop(c));
        board[row1][6].setPiece(new Horse(c));
        board[row1][7].setPiece(new Rook(c));
        for (int i = 0; i < 8; i++) {
            board[row2][i].setPiece(new Pawn(c));
        }
    }

    public boolean move(Cell source, Cell target) {
        int rowSource = source.getRow();
        int colSource = source.getColumn();
        int rowTarget = target.getRow();
        int colTarget = target.getColumn();

        if (!source.getPiece().isValidMove(rowSource, colSource, rowTarget, colTarget)) {
            return false;
        } 

        target.setPiece(source.getPiece());
        source.setPiece(null);
        
        return true;
    }

    public void display() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                Piece piece = board[i][j].getPiece();
                if (piece != null) {
                    System.out.print(" " + piece.getColor().toString().charAt(0) + piece.toString() + " ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.print("|\n");
        }
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }
}
