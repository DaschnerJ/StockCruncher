package io.github.daschnerj.gui;

import io.github.daschnerj.gui.CSSLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneManager {

    Scene current;
    Stage stage;

    CSSLoader css;

    public SceneManager(Stage stage)
    {
        this.stage = stage;
        //creating a Group object
        Group group = new Group();

        //Creating a Scene by passing the group object, height and width
        Scene scene = new Scene(group ,600, 300);

        //We load css here since the scene is then finally safely created.
        css = new CSSLoader(this);
        //setting color to the scene
        scene.setFill(Color.BROWN);

        //Setting the title to Stage.
        stage.setTitle("Sample Application");

        //Adding the scene to Stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public Scene getScene()
    {
        return current;
    }

    public void setScene(Scene scene)
    {
        current = scene;
    }


}
