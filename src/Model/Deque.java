package Model;

public class Deque {
    private Node head;
    private Node tail;

    public Deque(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void pushFront(Point point){
        Node tmp = new Node(point, null, head);
        head.setPrv(tmp);
        head = tmp;
    }

    public void pushBack(Point point){
        Node tmp = new Node(point, tail, null);
        tail.setNxt(tmp);
        tail = tmp;
    }

    public void popFront(){
        Node tmp = head.getNxt();
        tmp.setPrv(null);
        head = tmp;
    }

    public void popBack(){
        Node tmp = tail.getPrv();
        tmp.setNxt(null);
        tail = tmp;
    }

}
