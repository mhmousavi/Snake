package View;

import Model.MainModel;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame{
    MainModel mainModel;

    public MainView(MainModel mainModel) {
        this.mainModel = mainModel;
        add(new Board(mainModel));

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
