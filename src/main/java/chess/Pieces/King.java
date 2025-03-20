package chess.Pieces;

import chess.Color;

public class King extends Piece {
    public King(Color c) {
        super(c);
    }

    public boolean isValidMove(int rowSource, int colSource, int rowTarget, int colTarget) {
        return true;
    }
}
