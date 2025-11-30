package com.sof.wowlike.domain.npc;

import com.sof.wowlike.domain.character.Stats;

public class Goblin extends Enemy {
    public Goblin(int id) {
        super (id ,"Goblin", 1,
                new Stats(
                        8,
                        6,
                        4,
                        5,
                        3
                )
        );
    }
}
