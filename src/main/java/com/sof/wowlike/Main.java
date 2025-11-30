package com.sof.wowlike;

import com.sof.wowlike.app.GameApplication;
import com.sof.wowlike.ui.screens.CharacterCreationScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private GameApplication gameApp;

    @Override
    public void start(Stage stage) {
        this.gameApp = new GameApplication();

        CharacterCreationScreen creationScreen = new CharacterCreationScreen(gameApp);

        Scene scene = new Scene(creationScreen.getRoot(), 600, 400);
        stage.setTitle("WoW-like RPG");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
