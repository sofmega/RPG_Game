package com.sof.wowlike.app;

import com.sof.wowlike.domain.character.CharacterClass;
import com.sof.wowlike.domain.character.Stats;
import com.sof.wowlike.domain.character.PlayerCharacter;
import com.sof.wowlike.domain.npc.Enemy;
import com.sof.wowlike.domain.npc.Goblin;

public class GameApplication {

    private PlayerCharacter currentPlayer;
    private int nextId = 1;
    
    public PlayerCharacter createNewPlayer(String name, CharacterClass characterClass) {
        
        Stats startingStats = characterClass.createStartingStats();

        currentPlayer = new PlayerCharacter (
            nextId++,
            name,
            1,
            startingStats,
            characterClass
        );
        return currentPlayer;
    }

    public PlayerCharacter getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean hasActiveGame() {
        return currentPlayer != null;
    }

    public void resetGame() {
        currentPlayer = null;
        nextId = 1;
    }
    public Enemy spawnGoblin () {
      return new Goblin(nextId++);
    };
}
