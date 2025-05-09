package SimpLwJGL;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class SimpLWindow {
    static private Runnable loop;
    public static long window;
    static public int screenWidth;
    static public int screenHeight;
    static public double deltaTime;
    static private double lastTime = GLFW.glfwGetTime();
    // Window creation
    public static void createWindow(int width, int height, String name, Runnable windowLoop, Runnable start) {
        screenWidth = width;
        screenHeight = height;
        loop = windowLoop;

        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Failed to initialize GLFW");
        }

        window = GLFW.glfwCreateWindow(width, height, name, 0, 0);
        if (window == 0) {
            throw new RuntimeException("Failed to create window!");
        }

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        start.run();

        while (!GLFW.glfwWindowShouldClose(window)) {
            updateWindowSize();
            SimpLEvents.KeyboardEvents.updateInput();

            deltaTime = GLFW.glfwGetTime() - lastTime;
            lastTime = GLFW.glfwGetTime();

            loop.run();

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    // Window clear content
    public static void clearContent() {
        glClear(GL_COLOR_BUFFER_BIT);
    }

    // Window set background color
    public static void setBackgroundRGB(int R, int G, int B) {
        float convR = (float) R / 255;
        float convG = (float) G / 255;
        float convB = (float) B / 255;
        glClearColor(convR, convG, convB, 1f);
    }

    // Screen size update
    private static void updateWindowSize() {
        try (org.lwjgl.system.MemoryStack stack = org.lwjgl.system.MemoryStack.stackPush()) {
            java.nio.IntBuffer width = stack.mallocInt(1);
            java.nio.IntBuffer height = stack.mallocInt(1);

            GLFW.glfwGetWindowSize(window, width, height);
            screenWidth = width.get(0);
            screenHeight = height.get(0);
        }
    }
}
