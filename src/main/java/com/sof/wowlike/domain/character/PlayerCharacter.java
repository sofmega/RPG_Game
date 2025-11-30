package com.sof.wowlike.domain.character;



public class PlayerCharacter extends Character {

    private final CharacterClass characterClass;
    private int experience;
    private int gold;

    public PlayerCharacter(int id, String name, int level, Stats stats, CharacterClass characterClass) {
        super(id, name, level, stats);
        this.characterClass = characterClass;
        this.experience = 0;
        this.gold = 0;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public void gainExperience(int exp) {
        this.experience += exp;

        // simple leveling rule for v1
        while (this.experience >= xpToNextLevel()) {
            this.experience -= xpToNextLevel();
            levelUp();
        }
    }

    public void gainGold(int amount) {
        this.gold += Math.max(amount, 0);
    }

    private int xpToNextLevel() {
        return getLevel() * 100;
    }

    private void levelUp() {
        // for now: just increase level by 1
        // (we'll upgrade this later with stat growth)
        // we need a setter or protected access in Character
        increaseLevelByOne();

        // restore HP/mana on level up (classic RPG feel)
        heal(getStats().getMaxHp());
        restoreResource(getStats().getMaxMp());
    }

}
