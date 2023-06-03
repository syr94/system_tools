package com.app.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainView {
    private Button addButton;

    public MainView() {
        addButton = new Button("Add Random Task And Earn Money");
    }

    public Scene getScene() {
        VBox vbox = new VBox(addButton);
        return new Scene(vbox, 300, 200);
    }

    public Button getAddButton() {
        return addButton;
    }
}