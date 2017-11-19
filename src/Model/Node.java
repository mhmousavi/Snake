package Model;

public class Node {
    private Point location;
    private Node prv;
    private Node nxt;

    public Node() {
    }

    public Node(Point location, Node prv, Node nxt) {
        this.location = location;
        this.prv = prv;
        this.nxt = nxt;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Node getPrv() {
        return prv;
    }

    public void setPrv(Node prv) {
        this.prv = prv;
    }

    public Node getNxt() {
        return nxt;
    }

    public void setNxt(Node nxt) {
        this.nxt = nxt;
    }
}
