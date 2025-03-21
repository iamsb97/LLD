package chess.Pieces;

import chess.Color;

public class Horse extends Piece {
    public Horse(Color c) {
        super(c);
    }
    
    public boolean isValidMove(int rowSource, int colSource, int rowTarget, int colTarget) {
        return true;
    }

    public String toString() {
        return new String("H");
    }
}
