import SimpLwJGL.SimpLRendering;
import SimpLwJGL.SimpLWindow;
import SimpLwJGL.SimpLInstances.Square;
import SimpLwJGL.SimpLInstances.Outlines.SquareOutline;

public class Main {

    private static Square square;
    private static SquareOutline outline;

    static public Runnable start = () -> {
        SimpLWindow.setBackgroundRGB(105, 105, 97);
        square = new Square(0, 0, 100, 100);
        outline = new SquareOutline(square);
    };

    static public Runnable update = () -> {
        SimpLWindow.clearContent();

        SimpLRendering.setRGBA(156, 185, 215, 1f);
        square.render();
        SimpLRendering.setLineThickness(3f);
        SimpLRendering.setRGBA(0, 0, 0, 1f);
        outline.render();
    };

    public static void main(String[] args) {
        SimpLWindow.createWindow(800, 800, "Game", update, start);
    }
}
