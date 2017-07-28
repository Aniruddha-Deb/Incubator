package com.sensei.javafx.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UIController extends Application {
	
	private Stage primaryStage = null;
	private AnchorPane rootLayout = null;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle( "Address App" );

		try {
			initRootLayout();
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
	
	public void initRootLayout() throws IOException {
        rootLayout = (AnchorPane)FXMLLoader.load( getClass().getResource( "../view/BaseUI.fxml" ) );

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();            
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
