import Controller.MainController;
import Model.IO;
import Model.MainModel;
import View.MainView;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(mainModel);
    }
}

