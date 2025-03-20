package chess;

import chess.Pieces.Piece;

public class Cell {
    private final int row;
    private final int col;
    private Piece piece;

    public Cell(int r, int c) {
        this.row = r;
        this.col = c;
        this.piece = null;
    }

    public void setPiece(Piece p) {
        this.piece = p;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.col;
    }

    public Piece getPiece() {
        return this.piece;
    }
}
