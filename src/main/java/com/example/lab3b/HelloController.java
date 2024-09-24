package com.example.lab3b;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.Desktop;
import java.net.URI;

public class HelloController {
    @FXML
    private Button onBack;
    @FXML
    private Button visit1;
    @FXML
    private Button visit2;
    @FXML
    private Button visit3;
    @FXML
    private Button visit4;
    @FXML
    private Button visit5;
    @FXML
    private Button visit6;
    @FXML
    private TextField onSearchBar;

    @FXML
    private Button onSearchButton;

    @FXML
    private Label history1;

    @FXML
    private Label history2;

    @FXML
    private Label history3;

    @FXML
    private Label history4;

    @FXML
    private Label history5;

    @FXML
    private Label history6;

    @FXML
    private void initialize() {
    }

    @FXML
    protected void onSearchButtonClick() {
        String searchText = onSearchBar.getText().trim();

        if (!searchText.startsWith("www.")) {
            searchText = "www." + searchText;
        }
        if (!searchText.endsWith(".com")) {
            searchText = searchText + ".com";
        }

        onSearchBar.setText(searchText);

        history6.setText(history5.getText());
        history5.setText(history4.getText());
        history4.setText(history3.getText());
        history3.setText(history2.getText());
        history2.setText(history1.getText());
        history1.setText(searchText);

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://" + searchText));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void onBackButtonClick() {
        history1.setText(history2.getText());
        history2.setText(history3.getText());
        history3.setText(history4.getText());
        history4.setText(history5.getText());
        history5.setText(history6.getText());
        history6.setText("     ");
    }

    @FXML
    public void onVisit1Click(ActionEvent actionEvent) {
        openURLInBrowser(history1.getText());
    }

    @FXML
    public void onVisit2Click(ActionEvent actionEvent) {
        openURLInBrowser(history2.getText());
    }

    @FXML
    public void onVisit3Click(ActionEvent actionEvent) {
        openURLInBrowser(history3.getText());
    }

    @FXML
    public void onVisit4Click(ActionEvent actionEvent) {
        openURLInBrowser(history4.getText());
    }

    @FXML
    public void onVisit5Click(ActionEvent actionEvent) {
        openURLInBrowser(history5.getText());
    }

    @FXML
    public void onVisit6Click(ActionEvent actionEvent) {
        openURLInBrowser(history6.getText());
    }

    private void openURLInBrowser(String urlText) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("http://" + urlText));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
