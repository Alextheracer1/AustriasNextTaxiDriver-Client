package com.alextheracer1.austriasnexttaxidriverclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController implements Initializable {

  @FXML private Button newRunButton;
  private Button allRunsButton;

  private Boolean alreadyOpen;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    alreadyOpen = false;
  }

  private void openNewWindow(String windowName) {

    if (!alreadyOpen) {
      try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(windowName));
        /*
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = new Stage();
        stage.setTitle("Add new run");
        stage.setScene(scene);
        stage.setResizable(false);
        alreadyOpen = true;
        stage.setOnHidden(
            e -> {
              closeNewRunWindow();
            });
        stage.show();
      } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
      }
    } else {
      System.out.println("Window is already open");
    }
  }

  public void onButtonNewRun() {
    openNewWindow("newRun.fxml");
  }

  private void closeNewRunWindow() {
    alreadyOpen = false;
  }

  public void onButtonAllRuns() {
    openNewWindow("allRuns.fxml");
  }
}
