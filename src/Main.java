import SimpLwJGL.SimpLWindow;
import SimpLwJGL.SimpLShapes;
import SimpLwJGL.SimpLEvents;
import SimpLwJGL.SimpLEntities;
import static org.lwjgl.glfw.GLFW.*;

public class Main {

    static SimpLEntities entity;

    static Runnable start = () -> {
        System.out.println("Successfully started!");

        entity = new SimpLEntities(0, 0, 100, 100);
    };

    static Runnable frameLoop = () -> {
        SimpLWindow.setBackgroundRGB(178, 217, 255);
        SimpLWindow.clearContent();

        if (SimpLEvents.KeyboardEvents.isKeyDown(GLFW_KEY_W)) {
            entity.y += 6;
        }
        if (SimpLEvents.KeyboardEvents.isKeyDown(GLFW_KEY_S)) {
            entity.y -= 6;
        }
        if (SimpLEvents.KeyboardEvents.isKeyDown(GLFW_KEY_A)) {
            entity.x -= 8;
        }
        if (SimpLEvents.KeyboardEvents.isKeyDown(GLFW_KEY_D)) {
            entity.x += 8;
        }

        SimpLShapes.setRGBA(100, 100, 100, 1);
        entity.quadRender();
    };

    public static void main(String[] args) {
        SimpLWindow.createWindow(800, 600, "Game", frameLoop, start);
    }
}
