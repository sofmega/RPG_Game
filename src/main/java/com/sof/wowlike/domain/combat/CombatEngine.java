package com.sof.wowlike.domain.combat;

import com.sof.wowlike.domain.character.Character;

public class CombatEngine {
    public static String attack (Character attacker, Character defender) {
        int baseDamage = attacker.getStats().getAttackPower();
        int armor = defender.getStats().getArmor();

        int damage = Math.max(baseDamage - armor, 1);

        int critChance = attacker.getStats().getCritChance();
        boolean isCrit = Math.random() * 100 < critChance;

        if (isCrit) {
            damage *= 2;
        }

        defender.takeDamage(damage);

        return ( attacker.getName() + "Hits " + defender.getName()
        + (isCrit ? "with a CRIT" : " ")
        + "for " + damage + " damage!");
    }
}
