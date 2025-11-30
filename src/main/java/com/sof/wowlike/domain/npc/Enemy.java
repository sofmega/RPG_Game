package com.sof.wowlike.domain.npc;

import com.sof.wowlike.domain.character.Character;
import com.sof.wowlike.domain.character.Stats;

public abstract class Enemy extends Character {

    public Enemy(int id, String name, int level, Stats stats) {
        super(id, name, level, stats);
    }
}

