package View;

import Model.*;
import Model.Point;

import java.awt.*;
import java.awt.event.*;
import java.awt.peer.WindowPeer;
import javax.swing.*;


public class Board extends JPanel implements ActionListener{
    private MainModel mainModel;
    public static String UP = "u";
    public static String DOWN = "d";
    public static String RIGHT = "r";
    public static String LEFT = "l";
    public static int WIDTH = World.N * 24;
    public static int HEIGHT = World.M * 24;
    public static int DELAY = 150;


    private boolean inGame;
    private Timer timer;
    private Image snake;
    private Image food;
    private Image wall;
    private Image head;
    private Vector vec = new Vector(0, 0);

    public Board(MainModel mainModel) {
        this.mainModel = mainModel;
        inGame = true;
        addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImages();
        initGame();
    }

    private void initGame() {

        timer = new Timer(DELAY, this);
        timer.start();
    }


    public void showWorld(Graphics graphics){
        if(inGame == false) {
            gameOver(graphics);
            return;
        }
        for(int i = 0; i < World.N; i ++){
            for(int j = 0; j < World.M; j ++){
                Element element = mainModel.getWorld().getElement(new Point(i, j));

                if(mainModel.getWorld().getSnake().getHead().getX() == i &&
                        mainModel.getWorld().getSnake().getHead().getY() == j)
                    graphics.drawImage(head, i * 24, j * 24, this);
                else if(element.getType() == World.SNAKE)
                    graphics.drawImage(snake, i * 24, j * 24, this);


                if(element.getType() == World.FOOD)
                    graphics.drawImage(food, i * 24 , j * 24, this);

                if(element.getType() == World.WALL)
                    graphics.drawImage(wall, i * 24, j * 24, this);
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        showWorld(graphics);
    }

    public void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (WIDTH - metr.stringWidth(msg)) / 2, HEIGHT / 2);
    }

    public void actionPerformed(ActionEvent e) {
        if(inGame)
            inGame = mainModel.getWorld().getSnake().move(vec);

        //System.out.println("here!");
        repaint();
    }

    public void loadImages() {

        snake = new ImageIcon("src/View/snake.png").getImage();
        food = new ImageIcon("src/View/food.png").getImage();
        wall = new ImageIcon("src/View/wall.png").getImage();
        head = new ImageIcon("src/View/head.png").getImage();

    }

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if(key == KeyEvent.VK_UP && vec.getY() != +1)
                vec = new Vector(0, -1);

            if(key == KeyEvent.VK_DOWN && vec.getY() != -1)
                vec = new Vector(0, +1);

            if(key == KeyEvent.VK_LEFT && vec.getX() != +1)
                vec = new Vector(-1, 0);

            if(key == KeyEvent.VK_RIGHT && vec.getX() != -1)
                vec = new Vector(+1, 0);

        }

    }
}
