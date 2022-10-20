package com.alextheracer1.austriasnexttaxidriverclient;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class NewRunController implements Initializable {

  @FXML public Button newRunButton;

  // Driver Section
  @FXML public TextField driverDeathCauseTextField;
  @FXML public CheckBox isAiDriverCheckBox;

  // Taxi Run Section
  @FXML public TextField videoURLTextField;
  @FXML public TextField reasonForEliminationTextField;
  @FXML public TextField reasonForEliminationDetailsTextField;
  @FXML public TextField weatherConditionTextField;
  @FXML public TextField timeOfDayTextField;
  @FXML public ChoiceBox<String> directionChoiceBox;
  // @FXML public ChoiceBox<String> reasonForEliminationChoiceBox;
  // @FXML public ChoiceBox<String> dayLightChoiceBox;

  public void addRun() {
    System.out.println("New run added");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ArrayList<String> directionList = new ArrayList<>();
    directionList.add("Made it only one way");
    directionList.add("Made it both ways");
    directionList.add("Made it back to the start");
    directionChoiceBox.setItems(FXCollections.observableArrayList(directionList));
    /*
       ArrayList<String> reasonForEliminationList = new ArrayList<>();
       reasonForEliminationList.add("Roll over");
       reasonForEliminationList.add("Turn");
       reasonForEliminationList.add("Trench");
       reasonForEliminationList.add("End");
       reasonForEliminationList.add("Other");
       reasonForEliminationChoiceBox.setItems(FXCollections.observableArrayList(reasonForEliminationList));

       ArrayList<String> dayLightList = new ArrayList<>();
       dayLightList.add("Day");
       dayLightList.add("Night");
       dayLightList.add("Day -> Night");
       dayLightList.add("Night -> Day");
       dayLightChoiceBox.setItems(FXCollections.observableArrayList(dayLightList));

    */
  }
}
