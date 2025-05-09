package SimpLwJGL.SimpLInstances.Outlines;

import SimpLwJGL.SimpLInstances.Square;
import SimpLwJGL.SimpLRendering;
import SimpLwJGL.SimpLWindow;

public class QuadOutline {
    public float x1, y1,
                 x2, y2,
                 x3, y3,
                 x4, y4;

    public QuadOutline(Square square) {
        float tempPosX = square.x;
        float tempPosY = square.y;
        float tempSizeX = square.width;
        float tempSizeY = square.height;

        float calcPosX = tempPosX / SimpLWindow.windowWidth;
        float calcPosY = tempPosY / SimpLWindow.windowHeight;

        float calcSizeX = Math.abs(tempSizeX) / SimpLWindow.windowWidth;
        float calcSizeY = Math.abs(tempSizeY) / SimpLWindow.windowHeight;

        x1 = calcPosX - calcSizeX;
        y1 = calcPosY - calcSizeY;

        x2 = calcPosX - calcSizeX;
        y2 = calcPosY + calcSizeY;

        x3 = calcPosX + calcSizeX;
        y3 = calcPosY + calcSizeY;

        x4 = calcPosX + calcSizeX;
        y4 = calcPosY - calcSizeY;
    }

    public void render() {
        SimpLRendering.drawCustomLine(x1, y1, x2, y2);
        SimpLRendering.drawCustomLine(x2, y2, x3, y3);
        SimpLRendering.drawCustomLine(x3, y3, x4, y4);
        SimpLRendering.drawCustomLine(x4, y4, x1, y1);
    }
}
