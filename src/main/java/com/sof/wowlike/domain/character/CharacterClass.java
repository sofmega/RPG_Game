package com.sof.wowlike.domain.character;

public enum CharacterClass {
    WARRIOR,
    MAGE,
    ROGUE,
    PRIEST,
    RANGER;

    public Stats createStartingStats() {
        return switch (this) {
            case WARRIOR -> new Stats(15, 10, 5, 12, 8);
            case MAGE -> new Stats(5, 8, 15, 6, 12);
            case ROGUE -> new Stats(10, 15, 7, 8, 10);
            case PRIEST -> new Stats(6, 9, 14, 7, 13);
            case RANGER -> new Stats(9, 14, 6, 10, 9);

        };
    }
}
