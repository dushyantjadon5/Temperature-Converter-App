
package com.dsj.myfirstapp;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 


public class ComDsjMyFirstApp extends Application {
    
    public static void main (String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        
        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }
    
    private MenuBar createMenu() {
        
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> {
            System.out.println("New Menu Item cliked");
            reset();
        });
        
        SeparatorMenuItem sepMenuItm = new SeparatorMenuItem();
              
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        
        fileMenu.getItems().addAll(newMenuItem, sepMenuItm, quitMenuItem);
        
        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        
        aboutMenuItem.setOnAction(event -> aboutApp());
        
        
        helpMenu.getItems().addAll(aboutMenuItem);
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        
        return menuBar;
        
    }
    
    public void reset() {
        //userInputField.getChildren().clear();
    }

    public static void aboutApp() {
        //throw new UnsupportedOperationException("Not supported yet.");
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing awesome games. ");
        
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);
        
        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
        
        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
            System.out.println("Yes Button Clicked");
        } else {
            System.out.println("No Button Clicked");
        }
        
        
    }
}
   