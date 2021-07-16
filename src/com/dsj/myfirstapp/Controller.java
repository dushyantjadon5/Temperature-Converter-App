
package com.dsj.myfirstapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;
    
    @FXML
    public ChoiceBox<String> choiceBox;
    
    @FXML
    public TextField userInputField;
    
    @FXML
    public Button convertButton;
    
    private static final String C_T_F = "Celsius to Fahrenheit";
    private static final String F_T_C = "Fahrenheit to Celsius";
    
    private boolean isC_T_F = true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        choiceBox.getItems().add(C_T_F);
        choiceBox.getItems().add(F_T_C);
        
        choiceBox.setValue(C_T_F);
        
        choiceBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            //System.out.println(newValue);
            if(newValue.equals(C_T_F)) {
                isC_T_F = true;
            } else {
                isC_T_F = false;
            }
        });
        
        convertButton.setOnAction((ActionEvent event) -> {
            //System.out.println("Button Clicked");
            convert();
        });
    }    

    private void convert() {
        String input = userInputField.getText();
        
        float enteredTemp = 0.0f;
        try {
          enteredTemp = Float.parseFloat(input);
        } catch (Exception e) {
            warnUser();
            return;
        }
        
        float newTemp = 0.0f;
        if(isC_T_F) {
            newTemp = (enteredTemp * 9 / 5) + 32;
        } else {
            newTemp = (enteredTemp - 32) * 5 / 9;
        }
        display(newTemp);
    }
    private void warnUser() {
        Alert altDia = new Alert(Alert.AlertType.ERROR);
        altDia.setTitle("ERROR OCCURED");
        altDia.setHeaderText("INVALID TEMPERATURE ENTERED");
        altDia.setContentText("Please Enter the valid temperature!!");
        altDia.show();
    }

    private void display(float newTemp) {
        String unit = isC_T_F? "F" : "C";
        System.out.println("The Temperature is:" + newTemp + unit);
        
        Alert altDia = new Alert(Alert.AlertType.INFORMATION);
        altDia.setTitle("Result");
        altDia.setContentText("The Temperature is: " + newTemp + unit);
        altDia.show();
    }

    
    
    
}
