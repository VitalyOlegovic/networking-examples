package org.example.socketclient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class DictClientInterface extends Application {

    TextField tfWord;
    TextField tfPort;
    TextArea ta;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        
        Label lbWord = new Label("Lemma:");
        GridPane.setRowIndex(lbWord, 0);
        GridPane.setColumnIndex(lbWord, 0);
        root.getChildren().add(lbWord);
        
        tfWord = new TextField();
        tfWord.setText("");
        GridPane.setRowIndex(tfWord,0);
        GridPane.setColumnIndex(tfWord, 1);
        root.getChildren().add(tfWord);
        
        Button btn = new Button();
        GridPane.setRowIndex(btn, 1);
        GridPane.setColumnIndex(btn, 0);
        btn.setText("Trova");
        DictClientEventHandler dceh = new DictClientEventHandler();
        btn.setOnAction(dceh);
        root.getChildren().add(btn);
        
        ta = new TextArea();
        ta.setDisable(false);
        GridPane.setRowIndex(ta, 2);
        GridPane.setColumnSpan(ta, 2);
        GridPane.setVgrow(ta, Priority.ALWAYS);
        GridPane.setHgrow(ta, Priority.ALWAYS);
        root.getChildren().add(ta);
        
        Scene scene = new Scene(root, 550, 900);
        
        primaryStage.setTitle("Socket client interface");
        //primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class DictClientEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            try {
                String definition = DictClient.define(tfWord.getText(), DictClient.Dictionary.ENGLISH);
                ta.setText(definition);
            } catch (IOException ex) {
                Logger.getLogger(DictClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
