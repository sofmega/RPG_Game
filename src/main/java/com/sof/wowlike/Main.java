package com.sof.wowlike;

import com.sof.wowlike.app.GameApplication;
import com.sof.wowlike.domain.npc.Enemy;
import com.sof.wowlike.ui.screens.BattleScreen;
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

        // callback after creation
        creationScreen.setOnCharacterCreated(() -> {
            Enemy goblin = gameApp.spawnGoblin();
            BattleScreen battle = new BattleScreen(gameApp, goblin);

            Scene battleScene = new Scene(battle.getRoot(), 600, 400);
            stage.setScene(battleScene);
        });
        Scene creationScene = new Scene(creationScreen.getRoot(), 600, 400);
        stage.setScene(creationScene);
        stage.setTitle("WoW-like RPG");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
