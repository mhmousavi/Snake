package Controller;

import Model.MainModel;
import View.MainView;

import javax.swing.*;
import java.awt.*;

public class MainController {
    private MainModel mainModel;

    public MainController(MainModel mainModel) {
        this.mainModel = mainModel;
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame ex = new MainView(mainModel);
                ex.setVisible(true);
            }
        });
    }
}
