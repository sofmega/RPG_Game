package com.sof.wowlike.domain.character;

public class Stats {

    private final int strength;
    private final int agility;
    private final int intelligence;
    private final int stamina;
    private final int spirit;

    public Stats(int str, int agi, int intel, int stamina, int spirit) {
        this.strength = str;
        this.agility = agi;
        this.intelligence = intel;
        this.stamina = stamina;
        this.spirit = spirit;
    }

    public int getStr() {
        return strength;
    }

    public int getAgi() {
        return agility;
    }

    public int getIntel() {
        return intelligence;
    }

    public int getStamina() {
        return stamina;
    }

    public int getSpirit() {
        return spirit;
    }

 
    //drived stats

    public int getMaxHp() {
        return 50 + (stamina * 10);
    }
    public int getMaxMp() {
        return 30 + (intelligence * 15);
    }
    public int getArmor() {
        return  agility / 2;
    }
    public int getAttackPower() {
        return strength * 2 + agility;
    }
    public int getSpellPower() {
        return intelligence * 2 + spirit;
    }
    public int getCritChance() {
        return agility / 5;
    }
    
    @Override
    public String toString() {
        return "Stats{" +
                "strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", stamina=" + stamina +
                ", spirit=" + spirit +
                '}';
    }


}
