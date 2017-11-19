package Model;

import java.awt.peer.WindowPeer;

public class Snake {
    private Deque snake;
    private World world;

    public Snake(Point point, World world) {
        this.world = world;
        Node node = new Node(point, null, null);
        snake = new Deque(node, node);
    }

    public Point getHead(){
        return snake.getHead().getLocation();
    }

    public boolean move(Vector vec){
        if(vec.getX() == 0 && vec.getY() == 0) return true;

        Point point = snake.getHead().getLocation().moveBy(vec);
        Element tmp = world.getElement(point);
        if(tmp.getType() == World.WALL) return false;
        if(tmp.getType() == World.SNAKE) return false;
        if(tmp.getType() == World.FIELD){
            tmp.setType(World.SNAKE);
            world.setElement(tmp);
           snake.pushFront(point);

            Element tail = world.getElement(snake.getTail().getLocation());
            tail.setType(World.FIELD);
            world.setElement(tail);
            snake.popBack();
        }
        else if(tmp.getType() == World.FOOD){
            world.addFood();
            tmp.setType(World.SNAKE);
            world.setElement(tmp);
            snake.pushFront(point);
        }
        return true;
    }
}
