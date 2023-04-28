package edu.guilford;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

// IndividualPane is a class that extends one of the Pane classes
public class IndividualPane extends Pane {
    //Could have GridPane, TitlePane, StckPane, Pane, BorderPane, and others
    //These organize the components we want to display in different ways

    //Three String attributes
    // private String name;
    // private String email;
    // private String phone;

    //Individual attribute
    private Individual individual;

    // add a textfield attribute for the name
    private TextField nameField;
    // add a textfield attribute for the email
    private TextField emailField;
    // add a textfield attribute for the phone
    private TextField phoneField;

    //Add a submit button attribute
    private Button submitButton;

    //Three label attributes for the name, email, and phone
    private Label nameLabel;
    private Label emailLabel;
    private Label phoneLabel;

    //Step 1: Declare an ImageView object
    private ImageView imageView;

    //Step 1: Declare a Circle Shape object
    private Circle circle;

    //Constructor
    public IndividualPane(Individual individual) {
        //Set the individual attribute to the individual parameter
        this.individual = individual;

        //Instantiate the textfield for the name
        nameField = new TextField();
        //Instantiate the textfield for the email
        emailField = new TextField();
        //Instantiate the textfield for the phone
        phoneField = new TextField();

        //Step 2: Instantiate the ImageView object with the image in the folder
        //Get the path of the file that contains the image
        File small = new File(this.getClass().getResource("smallPhoto.jpg").getPath());
        
        //URI stands for Uniform Resource Identifier and it's similar to a URL
        imageView = new ImageView(small.toURI().toString());

        //Instantiate the submit button
        submitButton = new Button("Submit");

        //Step 2: Instantiate the Circle object
        circle = new Circle(100, 100, 50);
        //Change the color of circle to blue
        circle.setStyle("-fx-fill: red");
        //Change the opacity of the circle to 50%
        circle.setStyle("-fx-opacity: 0.5");

        //Instantiate the label attributes
        nameLabel = new Label("Name: " + individual.getName());
        emailLabel = new Label("Email: " + individual.getEmail());
        phoneLabel = new Label("Phone: " + individual.getPhone());

        //Add labels to the pane
        nameLabel.relocate(10, 10);
        emailLabel.relocate(10, 40);
        phoneLabel.relocate(10, 70);

        // Add textFields to the pane next the to the labels
        nameField.relocate(130, 10);
        emailField.relocate(130, 40);
        phoneField.relocate(130, 70);

        // Add the submit button to the pane
        submitButton.relocate(10, 160);

        //Change the size of the imageView
        imageView.setFitWidth(600);
        //Preserve the aspect ratio of the image (the ratio of width to height)
        imageView.setPreserveRatio(true);
        //Rotate Image
        // imageView.setRotate(45);

        //Step 3: Add the Circle to the pane below the submit button
        circle.relocate(10, 200);

        //Step 3: Add the ImageView to the pane to the right of the textFields
        imageView.relocate(300, 10);

        //Give the pane a border
        this.setStyle("-fx-border-color: black");
        //and a background color
        this.setStyle("-fx-background-color: lightblue");

        //Add a listener for the button that changes the labels
        submitButton.setOnAction(e -> {
            //Set the name label to the name textfield
            nameLabel.setText("Name: " + nameField.getText());
            //Set the email label to the email textfield
            emailLabel.setText("Email: " + emailField.getText());
            //Set the phone label to the phone textfield
            phoneLabel.setText("Phone: " + phoneField.getText());
            //Update the individual attribute with the new data
            individual.setName(nameField.getText());
            individual.setEmail(emailField.getText());
            individual.setPhone(phoneField.getText());
            System.out.println(e.toString());
        });

        //Add all the components to the pane
        getChildren().addAll(nameLabel, emailLabel, phoneLabel, nameField, 
        emailField, phoneField, submitButton, imageView, circle);
    }
}
