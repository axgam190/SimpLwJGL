package SimpLwJGL;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class SimpLShapes {

    public static void setRGBA(int R, int G, int B, int A) {
        float convR = (float) R / 255;
        float convG = (float) G / 255;
        float convB = (float) B / 255;
        glColor4f(convR, convG, convB, A);
    }

    public static void drawCustomQuad(
            float point1X, float point1Y,
            float point2X, float point2Y,
            float point3X, float point3Y,
            float point4X, float point4Y
    ) {
        glBegin(GL_QUADS);
        glVertex2f(point1X, point1Y);
        glVertex2f(point2X, point2Y);
        glVertex2f(point3X, point3Y);
        glVertex2f(point4X, point4Y);
        glEnd();
    }
    public static void drawFixedQuad(float posX, float posY, float sizeX, float sizeY) {
        float calcPosX = posX / SimpLWindow.screenWidth;
        float calcPosY = posY / SimpLWindow.screenHeight;

        float calcSizeX = Math.abs(sizeX) / SimpLWindow.screenWidth;
        float calcSizeY = Math.abs(sizeY) / SimpLWindow.screenHeight;

        float calcPtX1 = calcPosX - calcSizeX;
        float calcPtY1 = calcPosY - calcSizeY;

        float calcPtX2 = calcPosX - calcSizeX;
        float calcPtY2 = calcPosY + calcSizeY;

        float calcPtX3 = calcPosX + calcSizeX;
        float calcPtY3 = calcPosY + calcSizeY;

        float calcPtX4 = calcPosX + calcSizeX;
        float calcPtY4 = calcPosY - calcSizeY;

        drawCustomQuad(
                calcPtX1, calcPtY1,
                calcPtX2, calcPtY2,
                calcPtX3, calcPtY3,
                calcPtX4, calcPtY4
        );
    }
}
