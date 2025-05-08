package SimpLwJGL;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.*;

public class SimpLEvents {
    public static class KeyboardEvents {
        public static boolean isKeyDown(int key) {
            return GLFW.glfwGetKey(SimpLWindow.window, key) == GLFW_PRESS;
        }
    }
}
