package chess.Pieces;

import chess.Color;

public abstract class Piece {
    private final Color color;

    public Piece(Color c) {
        this.color = c;
    }

    public abstract boolean isValidMove(int rowSource, int colSource, int rowTarget, int colTarget);

    public Color getColor() {
        return this.color;
    }
}
