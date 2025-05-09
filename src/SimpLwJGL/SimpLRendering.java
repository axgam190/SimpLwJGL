package SimpLwJGL;
import static org.lwjgl.opengl.GL11.*;

public class SimpLRendering {

    public static void setRGBA(int R, int G, int B, float A) {
        float convR = (float) R / 255;
        float convG = (float) G / 255;
        float convB = (float) B / 255;
        glColor4f(convR, convG, convB, A);
    }

    public static void setLineThickness(float pixel_thickness) {
        glLineWidth(pixel_thickness);
    }

    public static void drawCustomLine(float point1X, float point1Y,
                                float point2X, float point2Y) {
        glBegin(GL_LINES);
        glVertex2f(point1X, point1Y);
        glVertex2f(point2X, point2Y);
        glEnd();
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
        float calcPosX = posX / SimpLWindow.windowWidth;
        float calcPosY = posY / SimpLWindow.windowHeight;

        float calcSizeX = Math.abs(sizeX) / SimpLWindow.windowWidth;
        float calcSizeY = Math.abs(sizeY) / SimpLWindow.windowHeight;

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

    public static void drawFixedLine(
            float posX1, float posY1,
            float posX2, float posY2
    ) {
        float calcPosX1 = posX1 / SimpLWindow.windowWidth;
        float calcPosX2 = posX2 / SimpLWindow.windowWidth;

        float calcPosY1 = posY1 / SimpLWindow.windowHeight;
        float calcPosY2 = posY2 / SimpLWindow.windowHeight;

        drawCustomLine(calcPosX1, calcPosY1, calcPosX2, calcPosY2);
    }
}
