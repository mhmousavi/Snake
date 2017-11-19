package Model;

public class Player {
    private String name;
    private Snake snake;

    public Player() {
    }

    public Player(String name, Snake snake) {
        this.name = name;
        this.snake = snake;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
