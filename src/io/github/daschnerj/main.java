package io.github.daschnerj;

import io.github.daschnerj.gui.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class main extends Application {

    SceneManager sm;

    @Override
    public void start(Stage primaryStage) throws Exception {
        sm = new SceneManager(primaryStage);
    }

    public static void main(String args[]){
        launch(args);
    }

    private void preload()
    {
        makePath(Variables.dataPath);
        makePath(Variables.configPath);
        makePath(Variables.cssPath);
        makePath(Variables.downloadPath);
    }

    private void makePath(String path)
    {
        File directory = new File(path);
        if (! directory.exists()){
            directory.mkdirs();
        }
    }
}
