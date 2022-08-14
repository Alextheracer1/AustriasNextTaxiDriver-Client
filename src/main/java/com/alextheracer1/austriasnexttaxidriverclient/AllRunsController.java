package com.alextheracer1.austriasnexttaxidriverclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AllRunsController implements Initializable {

  @FXML public Label countLabel;
  @FXML public ListView<String> runsView;

  private final String apiUrl = "http://localhost:8080/api/getAllTaxiRuns";

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    countLabel.setText(
        "There are currently "
            + UrlRequest("http://localhost:8080/api/getAllTaxiRunsCount")
            + " Runs");
    runsView.getItems().addAll(UrlRequest(apiUrl));
  }

  private String UrlRequest(String apiUrl) {
    StringBuilder result = new StringBuilder();
    URL url = null;
    try {
      url = new URL(apiUrl);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
    HttpURLConnection conn = null;
    try {
      conn = (HttpURLConnection) url.openConnection();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    try {
      conn.setRequestMethod("GET");
    } catch (ProtocolException e) {
      throw new RuntimeException(e);
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
      for (String line; (line = reader.readLine()) != null; ) {
        result.append(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return result.toString();
  }
}
