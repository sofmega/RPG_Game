package com.sof.wowlike.ui.screens;

import com.sof.wowlike.app.GameApplication;
import com.sof.wowlike.domain.character.PlayerCharacter;
import com.sof.wowlike.domain.combat.CombatEngine;
import com.sof.wowlike.domain.npc.Enemy;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BattleScreen {

    private final GameApplication gameApp;
    private final PlayerCharacter player;
    private final Enemy enemy;

    private final VBox root = new VBox(15);

    private final Label playerHpLabel = new Label();
    private final Label enemyHpLabel = new Label();
    private final Label logLabel = new Label();

    public BattleScreen(GameApplication gameApp, Enemy enemy) {
        this.gameApp = gameApp;
        this.player = gameApp.getCurrentPlayer();
        this.enemy = enemy;

        setupLayout();
        updateHpLabels();
    }

    private void setupLayout() {
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label title = new Label("⚔ Battle!");
        title.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");

        Button attackBtn = new Button("ATTACK");
        attackBtn.setMinWidth(200);
        attackBtn.setOnAction(e -> onAttack());

        logLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #333;");

        root.getChildren().addAll(title, playerHpLabel, enemyHpLabel, attackBtn, logLabel);
    }

    private void updateHpLabels() {
        playerHpLabel.setText("Player HP: " + player.getCurrentHp() + "/" + player.getStats().getMaxHp());
        enemyHpLabel.setText(enemy.getName() + " HP: " + enemy.getCurrentHp() + "/" + enemy.getStats().getMaxHp());
    }

    private void onAttack() {
        if (!enemy.isAlive() || !player.isAlive()) return;

        // Player attacks enemy
        String log = CombatEngine.attack(player, enemy);
        logLabel.setText(log);

        updateHpLabels();

        // Enemy dead
        if (!enemy.isAlive()) {
            logLabel.setText(log + "\n🏆 You defeated the enemy!");
            return;
        }

        // Enemy attacks player
        String enemyLog = CombatEngine.attack(enemy, player);
        logLabel.setText(log + "\n" + enemyLog);

        updateHpLabels();

        if (!player.isAlive()) {
            logLabel.setText(log + "\n" + enemyLog + "\n💀 You died!");
        }
    }

    public Parent getRoot() {
        return root;
    }
}
