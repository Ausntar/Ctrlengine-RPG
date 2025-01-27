package org.ctrlengine.ctrlengine_rpg;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static org.ctrlengine.ctrlengine_rpg.core.FileManagement.getPath;
import static org.ctrlengine.ctrlengine_rpg.window.Window.imageAdaptive;
import static org.ctrlengine.ctrlengine_rpg.window.Window.loadImage;

/**
 * @author Ctrlengine Development Team
 */
public class Application extends javafx.application.Application {
    int width,height;
    String title;
    Stage primaryStage;
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 400);
        imageAdaptive(loadImage(getPath+"images/icon.png",scene,root,primaryStage),primaryStage);
        primaryStage.setTitle("JavaFX Image Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}