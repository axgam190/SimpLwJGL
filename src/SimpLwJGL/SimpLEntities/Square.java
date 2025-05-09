package SimpLwJGL.SimpLEntities;

import SimpLwJGL.SimpLShapes;

public class Square {
    public float x, y;
    public float width, height;

    public Square(float posX, float posY, float sizeX, float sizeY) {
        this.x = posX;
        this.y = posY;
        this.width = sizeX;
        this.height = sizeY;
    }

    public void render() {
        SimpLShapes.drawFixedQuad(x, y, width, height);
    }
}
