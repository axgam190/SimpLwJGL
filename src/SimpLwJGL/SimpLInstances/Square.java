package SimpLwJGL.SimpLInstances;

import SimpLwJGL.SimpLRendering;

public class Square {
    public float x, y;
    public float width, height;
    public final String type = "Quad";

    public Square(float posX, float posY, float sizeX, float sizeY) {
        this.x = posX;
        this.y = posY;
        this.width = sizeX;
        this.height = sizeY;
    }

    public void render() {
        SimpLRendering.drawFixedQuad(x, y, width, height);
    }
}
