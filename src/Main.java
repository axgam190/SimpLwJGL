import SimpLwJGL.SimpLWindow;
import SimpLwJGL.SimpLEntities.Square;

public class Main {

    private static Square square;

    static public Runnable start = () -> {
        SimpLWindow.setBackgroundRGB(170, 155, 130);
        square = new Square(0, 0, 100, 100);
    };

    static public Runnable update = () -> {
        SimpLWindow.clearContent();
        square.render();

    };

    public static void main(String[] args) {
        SimpLWindow.createWindow(600, 600, "Game", update, start);
    }
}
