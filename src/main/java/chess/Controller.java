package chess;

public class Controller {
    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        ChessGame game = new ChessGame(user1, user2);
        game.start();
    }
}
