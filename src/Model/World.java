package Model;

import java.awt.peer.WindowPeer;
import java.io.IOException;
import java.util.Random;

public class World {
    public static int N = 20;
    public static int M = 20;
    public static char FOOD = 'o';
    public static char FIELD = '.';
    public static char SNAKE = '#';
    public static char WALL = 'w';


    private Element map[][] = new Element[N][M];
    private Player player;
    private Snake snake;

    public World() {
        IO io = new IO(this);
        try {
            io.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addFood();
        addSnake();
    }

    public Element getElement(Point point){
        return map[point.getX()][point.getY()];
    }
    public void setElement(Element element){
        map[element.getPoint().getX()][element.getPoint().getY()] = element;
    }

    public void addFood(){
        Point point = new Point();
        Random rand = new Random();
        do {
            point.setX(rand.nextInt(N));
            point.setY(rand.nextInt(M));
        }while(getElement(point).getType() != FIELD);
        Element element = getElement(point);
        element.setType(FOOD);
        setElement(element);
    }

    public void addSnake(){
        Point point = new Point();
        Random rand = new Random();
        do {
            point.setX(rand.nextInt(N));
            point.setY(rand.nextInt(M));
        }while(getElement(point).getType() != FIELD);
        Element element = getElement(point);
        element.setType(SNAKE);
        setElement(element);
        snake = new Snake(point, this);

    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public static int getN() {
        return N;
    }

    public static void setN(int n) {
        N = n;
    }

    public static int getM() {
        return M;
    }

    public static void setM(int m) {
        M = m;
    }

    public Element[][] getMap() {
        return map;
    }

    public void setMap(Element[][] map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
