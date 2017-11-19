package Model;

public class Element {
    private Point point;
    private char type;
    private World world;

    public Element() {
    }

    public Element(Point point, char type, World world) {
        this.point = point;
        this.type = type;
        this.world = world;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
