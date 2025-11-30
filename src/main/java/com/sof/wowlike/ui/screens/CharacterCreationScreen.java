package com.sof.wowlike.ui.screens;

import com.sof.wowlike.app.GameApplication;
import com.sof.wowlike.domain.character.CharacterClass;
import com.sof.wowlike.domain.character.PlayerCharacter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CharacterCreationScreen {

    private final GameApplication gameApp;
    private final VBox root = new VBox(12);

    private final Label title = new Label("Create Your Character");
    private final TextField nameField = new TextField();
    private final Label resultLabel = new Label("");

    public CharacterCreationScreen(GameApplication gameApp) {
        this.gameApp = gameApp;

        setupLayout();
        setupButtons();
    }

    private void setupLayout() {
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        nameField.setPromptText("Enter your character name");
        nameField.setMaxWidth(250);

        resultLabel.setStyle("-fx-font-size: 14px;");

        root.getChildren().addAll(title, nameField, resultLabel);
    }

    private void setupButtons() {
        // Create buttons for each class
        for (CharacterClass cls : CharacterClass.values()) {
            Button btn = new Button(cls.name());
            btn.setMinWidth(180);

            btn.setOnAction(e -> createPlayer(cls));

            root.getChildren().add(btn);
        }
    }

    private void createPlayer(CharacterClass chosenClass) {
        String name = nameField.getText();

        if (name == null || name.isBlank()) {
            resultLabel.setText("⚠ Please enter a name.");
            return;
        }

        PlayerCharacter player = gameApp.createNewPlayer(name, chosenClass);

        resultLabel.setText(
                "✅ Created: " + player.getName() +
                " (" + player.getCharacterClass() + ")\n" +
                "Stats -> " + player.getStats()
        );
    }

    public Parent getRoot() {
        return root;
    }
}
