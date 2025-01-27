package org.ctrlengine.ctrlengine_rpg.window;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static org.ctrlengine.ctrlengine_rpg.core.Log.logger;

/**
 * @author Ctrlengine Development Team
 */

public class Window {
    public static Image loadImage(String imagePath,Scene scene,StackPane root,Stage stage) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        root.getChildren().add(imageView);
        stage.setScene(scene);
        stage.show();
        return image;
    }
    public static void moveImage(Image image, double x, double y,Scene scene) {
        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        Stage stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void handoffImage(String path, Image image, double x, double y, Scene scene) {
        Image newImage = new Image(path);
        ImageView imageView = new ImageView(newImage);
        imageView.setTranslateX(x);
        imageView.setTranslateY(y);
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void imageAdaptive(Image image,Stage primaryStage){
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.fitWidthProperty().bind(primaryStage.widthProperty());
        imageView.fitHeightProperty().bind(primaryStage.heightProperty());

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
    }
}