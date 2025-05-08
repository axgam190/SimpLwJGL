package SimpLwJGL;

public class SimpLEntities {
    public int x, y;
    public int width, height;

    public SimpLEntities(int posX, int posY, int sizeX, int sizeY) {
        this.x = posX;
        this.y = posY;
        this.width = sizeX;
        this.height = sizeY;
    }

    public void quadRender() {
        SimpLShapes.drawFixedQuad(x, y, width, height);
    }
}
