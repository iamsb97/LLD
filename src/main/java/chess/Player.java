package chess;

public class Player {
    private final Color color;
    User user;

    public Player(User u, Color c) {
        this.color = c;
        this.user = u;
    }

    public Color getColor() {
        return this.color;
    }
}
