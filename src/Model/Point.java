package Model;

public class Point {
    private int x;
    private int y;

    public Point moveBy(Vector vec){
        int x = this.x + vec.getX();
        int y = this.y + vec.getY();
        if(x < 0)
            x  = World.N - 1;
        if(y < 0)
            y = World.M - 1;
        if(x == World.N)
            x = 0;
        if(y == World.M)
            y = 0;
        return new Point(x, y);
    }

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
