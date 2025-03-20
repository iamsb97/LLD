package chess.Pieces;

import chess.Color;

public class Bishop extends Piece {
    public Bishop(Color c) {
        super(c);
    }

    public boolean isValidMove(int rowSource, int colSource, int rowTarget, int colTarget) {
        return true;
    }
}
