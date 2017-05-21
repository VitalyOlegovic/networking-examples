package org.example.socketclient;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DaytimeClientInterface extends Application {
    
    TextField tfHost;
    TextField tfPort;
    TextArea ta;
    
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        
        Label lbHost = new Label("Nome nodo:");
        GridPane.setRowIndex(lbHost, 0);
        GridPane.setColumnIndex(lbHost, 0);
        root.getChildren().add(lbHost);
        
        tfHost = new TextField();
        tfHost.setText("time-c.nist.gov");
        GridPane.setRowIndex(tfHost,0);
        GridPane.setColumnIndex(tfHost, 1);
        root.getChildren().add(tfHost);
        
        Label lbPort = new Label("Numero porta:");
        GridPane.setRowIndex(lbPort, 1);
        GridPane.setColumnIndex(lbPort, 0);
        root.getChildren().add(lbPort);
        
        tfPort = new TextField();
        tfPort.setText("13");
        GridPane.setRowIndex(tfPort,1);
        GridPane.setColumnIndex(tfPort, 1);
        root.getChildren().add(tfPort);
        
        Button btn = new Button();
        GridPane.setRowIndex(btn, 2);
        GridPane.setColumnIndex(btn, 0);
        btn.setText("Read from socket");
        SocketClientEventHandler sceh = new SocketClientEventHandler();
        btn.setOnAction(sceh);
        
        root.getChildren().add(btn);
        
        ta = new TextArea();
        GridPane.setRowIndex(ta, 3);
        GridPane.setColumnSpan(ta, 2);
        root.getChildren().add(ta);
        
        Scene scene = new Scene(root, 500, 250);
        
        primaryStage.setTitle("Socket client interface");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    class SocketClientEventHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            String host = tfHost.getText();
            int port;
            try{
                port = Integer.parseInt(tfPort.getText());
            }catch(NumberFormatException nfe){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Numero porta errato");
                a.showAndWait();
                return;
            }
            String result = DaytimeClientDataISR.readFromSocket(host, port);
            ta.setText(result);
            System.out.println(tfHost.getText() + " " + tfPort.getText());
        }
    }
    
}

