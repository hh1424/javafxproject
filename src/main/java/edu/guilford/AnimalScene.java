package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class AnimalScene extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {     
        //Instantiate a VBox root node
        VBox root = new VBox();
        
        //Instantiate a stackPane root node
        // StackPane root = new StackPane();

        //Add both AnimalPane and IndividualPane to the stackPane root node
        // root.getChildren().addAll(new AnimalPane(new Animal()), new IndividualPane(new Individual()));
        root.getChildren().add(new AnimalPane(new Animal()));
        // root.getChildren().add(new IndividualPane(new Individual()));
        scene = new Scene(root, 900, 650);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}