package chess.Pieces;

import chess.Color;

public class Queen extends Piece {
    public Queen(Color c){
        super(c);
    }

    public boolean isValidMove(int rowSource, int colSource, int rowTarget, int colTarget) {
        return true;
    }
}
