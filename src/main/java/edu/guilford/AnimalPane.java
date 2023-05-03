package edu.guilford;

import java.io.File;
import java.util.Random;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

// AnimalPane is a Pane that extends one of the Pane classes from JavaFX.
public class AnimalPane extends Pane {
    //Animal attribute
    private Animal animal;

    //Add textfields for the Animal attributes
    private TextField nameField = new TextField();
    private TextField speciesField = new TextField();
    private TextField colorField = new TextField();
    private TextField ageField = new TextField();
    private TextField soundField = new TextField();

    //Add label attributes for the Animal attributes
    private Label nameLabel;
    private Label speciesLabel;
    private Label colorLabel;
    private Label ageLabel;
    private Label soundLabel;

    //Step 1: Add a submit button attribute
    private Button submitButton;

    //Step 1: Add a changeImage button attribute
    private Button changeImageButton;

    //Declare an ImageView for each of the five images
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;

    //Step 1: Declare a slider attribute
    private Slider slider;
    
    //Step 1: Declare Shape objects
    private Polygon hexagon;
    private Circle circle;
    private Polygon triangle;
    private Rectangle rectangle;

    private boolean valid; //Boolean to check if the input is valid
    private Label errorLabel; //Label to display an error message
    private Label stackTraceLabel; //Label to display the stack trace

    //Constructor for the AnimalPane class
    public AnimalPane(Animal animal) {
        //Set the Animal attribute
        this.animal = animal;

        //Step 2: Get the path of the file that contains the image
        File baby = new File(this.getClass().getResource("BabyAnimal.jpg").getPath());
        File penguin = new File(this.getClass().getResource("Penguin.jpg").getPath());
        File polarBear = new File(this.getClass().getResource("PolarBear.jpg").getPath());
        File tiger = new File(this.getClass().getResource("Tiger.jpg").getPath());
        File zebra = new File(this.getClass().getResource("Zebra.jpg").getPath());

        //Get the URI of the file
        imageView = new ImageView(baby.toURI().toString());
        imageView2 = new ImageView(penguin.toURI().toString());
        imageView3 = new ImageView(polarBear.toURI().toString());
        imageView4 = new ImageView(tiger.toURI().toString());
        imageView5 = new ImageView(zebra.toURI().toString());

        //Instantiate the textfields
        nameField = new TextField();
        speciesField = new TextField();
        colorField = new TextField();
        ageField = new TextField();
        soundField = new TextField();

        //Set the text for the labels
        nameLabel = new Label("Name: " + animal.getName());
        speciesLabel = new Label("Species: " + animal.getSpecies());
        colorLabel = new Label("Color: " + animal.getColor());
        ageLabel = new Label("Age: " + animal.getAge() + " years");
        soundLabel = new Label("Sound: " + animal.getSound());

        errorLabel = new Label("");
        stackTraceLabel = new Label("");

        //Step 2: Instantiate the shapes
        circle = new Circle(50, 50, 75);
        circle.setStyle("-fx-fill: red");
        hexagon = new Polygon(75, 75, 175, 75, 225, 150, 175, 225, 75, 225, 25, 150);
        hexagon.setStyle("-fx-fill: blue");        
        triangle = new Polygon(75, 100, 165, 225, 250, 100);
        triangle.setStyle("-fx-fill: green");
        rectangle = new Rectangle(50, 50, 150, 150);
        rectangle.setStyle("-fx-fill: yellow");

        //Change the size of each imageView FitWidth to 500
        imageView.setFitWidth(500);
        imageView2.setFitWidth(500);
        imageView3.setFitWidth(500);
        imageView4.setFitWidth(500);
        imageView5.setFitWidth(500);

        //Preserve the aspect ratio of each imageView
        imageView.setPreserveRatio(true);
        imageView2.setPreserveRatio(true);
        imageView3.setPreserveRatio(true);
        imageView4.setPreserveRatio(true);
        imageView5.setPreserveRatio(true);

        //Set the location of the labels
        nameLabel.relocate(10, 10);
        speciesLabel.relocate(10, 40);
        colorLabel.relocate(10, 70);
        ageLabel.relocate(10, 100);
        soundLabel.relocate(10, 130);

        //Set the location of the textfields
        nameField.relocate(130, 10);
        speciesField.relocate(130, 40);
        colorField.relocate(130, 70);
        ageField.relocate(130, 100);
        soundField.relocate(130, 130);

        //Set the location of the error label and stack 
        //trace label beside the textfields
        errorLabel.relocate(300, 10);
        stackTraceLabel.relocate(300, 40);

        //Step 3: Set the location of the ImageViews
        imageView.relocate(10, 200);
        imageView2.relocate(10, 200);
        imageView3.relocate(10, 200);
        imageView4.relocate(10, 200);
        imageView5.relocate(10, 200);

        //Instantiate the slider
        slider = new Slider(1, 4, 0);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1f);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(1f);
        //Set the location of the slider
        slider.relocate(660, 350);

        //Step 3: Set the location of the shapes
        circle.relocate(675, 150);
        hexagon.relocate(675, 150);
        triangle.relocate(675, 150);
        rectangle.relocate(675, 150);

        //Instantiate the submit button
        submitButton = new Button("Submit");
        //Set the location of the submit button
        submitButton.relocate(10, 160);
        //Change the color of the button to blue
        submitButton.setStyle("-fx-background-color: lightblue");
        //Set the size of the button to the default size
        submitButton.setPrefSize(100, 20);

        //Instantiate the changeImage button
        changeImageButton = new Button("Change Image");
        //Set the location of the changeImage button
        changeImageButton.relocate(600, 600);
        //Change the color of the button to blue
        changeImageButton.setStyle("-fx-background-color: lightblue");

        //Give the AnimalPane a Background color of light grey
        setStyle("-fx-background-color: lightgrey");
        //Set the size of the background to 1000 by 1000
        setPrefSize(1000, 1000);

        //Add a listener for the button that changes the labels
        submitButton.setOnAction(e -> {
            //Set the Animal attributes to the values in the textfields
            animal.setName(nameField.getText());
            animal.setSpecies(speciesField.getText());
            animal.setColor(colorField.getText());
            animal.setAge(Integer.parseInt(ageField.getText()));
            animal.setSound(soundField.getText());

            //Set the text for the labels
            nameLabel.setText("Name: " + animal.getName());
            speciesLabel.setText("Species: " + animal.getSpecies());
            colorLabel.setText("Color: " + animal.getColor());
            ageLabel.setText("Age: " + animal.getAge() + " years");
            soundLabel.setText("Sound: " + animal.getSound());
        });

        //Add a listener for the button to change the imageView to a random imageView when clicked
        changeImageButton.setOnAction(e -> {
            //Generate a random number between 1 and 5
            Random rand = new Random();
            int random = rand.nextInt(5) + 1;

            //If the random number is 1, set the imageView to imageView
            if (random == 1) {
                getChildren().removeAll(imageView2, imageView3, imageView4, imageView5);
                getChildren().add(imageView);
            }
            //If the random number is 2, set the imageView to imageView2
            else if (random == 2) {
                getChildren().removeAll(imageView, imageView3, imageView4, imageView5);
                getChildren().add(imageView2);
            }
            //If the random number is 3, set the imageView to imageView3
            else if (random == 3) {
                getChildren().removeAll(imageView, imageView2, imageView4, imageView5);
                getChildren().add(imageView3);
            }
            //If the random number is 4, set the imageView to imageView4
            else if (random == 4) {
                getChildren().removeAll(imageView, imageView2, imageView3, imageView5);
                getChildren().add(imageView4);
            }
            //If the random number is 5, set the imageView to imageView5
            else if (random == 5) {
                getChildren().removeAll(imageView, imageView2, imageView3, imageView4);
                getChildren().add(imageView5);
            }
        });

        //Add listener that changes the shape when the slider is moved
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            //If the slider is at 1, set the shape to circle
            if (slider.getValue() == 1) {
                getChildren().removeAll(hexagon, triangle, rectangle);
                getChildren().add(circle);
            }
            //If the slider is at 2, set the shape to star
            else if (slider.getValue() == 2) {
                getChildren().removeAll(circle, triangle, rectangle);
                getChildren().add(hexagon);
            }
            //If the slider is at 3, set the shape to triangle
            else if (slider.getValue() == 3) {
                getChildren().removeAll(circle, hexagon, rectangle);
                getChildren().add(triangle);
            }
            //If the slider is at 4, set the shape to rectangle
            else if (slider.getValue() == 4) {
                getChildren().removeAll(circle, hexagon, triangle);
                getChildren().add(rectangle);
            }
        });

        //Step 4: Add the items to the pane
        getChildren().addAll(nameLabel, speciesLabel, colorLabel, ageLabel, 
            soundLabel, nameField, speciesField, colorField, ageField, soundField, 
            submitButton, changeImageButton, imageView, slider, circle, errorLabel, stackTraceLabel);
    } 

    {
        try{
            animal.setAge(Integer.parseInt(ageField.getText()));
            if (animal.getAge() == 0) {
                throw new BadNumberException("Bad Number " + animal.getAge() + "Age cannot be 0");
            }
            valid = true;
        } catch (NumberFormatException ex) {
            //Display the error message in the label
            errorLabel.setText("Input for age is not an integer " + animal.getAge());
        } catch (BadNumberException ex) {
            //Display the stack trace in the stackTraceLabel
            stackTraceLabel.setText(ex.getMessage());
            System.exit(1);
        } while (!valid);
    }

    private static class BadNumberException extends Exception {
        public BadNumberException(String message) {
            super(message);
        }
    }
}

