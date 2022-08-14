package com.alextheracer1.austriasnexttaxidriverclient;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AustriasNextTaxiDriverClient extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(AustriasNextTaxiDriverClient.class.getResource("startPage.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 600, 400);
    stage.setTitle("AustriasNextTaxiDriverClient");
    stage.setScene(scene);
    stage.setResizable(false);
    InputStream stream = AustriasNextTaxiDriverClient.class.getResourceAsStream("taxi.jpg");
    if (stream != null) {
      stage.getIcons().add(new Image(stream));
    }
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}