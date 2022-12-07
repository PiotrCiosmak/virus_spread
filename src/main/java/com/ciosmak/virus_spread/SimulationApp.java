package com.ciosmak.virus_spread;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimulationApp extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(SimulationApp.class.getResource("simulation-view.fxml"));
        Scene scene = new Scene(loader.load(), 700, 800);
        primaryStage.setTitle("Virus Spread Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}