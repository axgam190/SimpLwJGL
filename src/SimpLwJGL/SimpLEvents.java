package SimpLwJGL;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.*;

public class SimpLEvents {
    static long window = SimpLWindow.window;

    public static class KeyboardEvents {

        static final int MAX_KEYS = 350;
        static boolean[] keys = new boolean[MAX_KEYS];
        static boolean[] keysLast = new boolean[MAX_KEYS];

        public static boolean isKeyDown(int key) {
            return GLFW.glfwGetKey(SimpLWindow.window, key) == GLFW_PRESS;
        }

        // Call this at the beginning of every frame
        public static void updateInput() {
            for (int i = 0; i < MAX_KEYS; i++) {
                keysLast[i] = keys[i];
                keys[i] = glfwGetKey(window, i) == GLFW_PRESS;
            }
        }

        // Returns true only on the frame the key is initially pressed
        public static boolean isKeyPressed(int key) {
            return keys[key] && !keysLast[key];
        }

        // Returns true only on the frame the key is released
        public static boolean isKeyReleased(int key) {
            return !keys[key] && keysLast[key];
        }
    }

    public static class TimeEvents {
        public static void waitTime(int milliseconds) {
            try {
                Thread.sleep(milliseconds); // convert to milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
