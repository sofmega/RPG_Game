    package com.sof.wowlike.domain.character;

    public abstract class Character {
        private final int id;
        private final String name;
        private int level;
        private final Stats stats;

        private int currentHp;
        private int currentResource;

        public Character(int id, String name, int lvl, Stats stats) {
            this.id = id;
            this.name = name;
            this.level = lvl;
            this.stats = stats;

            this.currentHp = stats.getMaxHp();
            this.currentResource = stats.getMaxMp();
        }

        public int getId() {
            return id;
        }   
        public String getName() {
            return name;
        }
        public int getLevel() {
            return level;
        }
        public Stats getStats() {
            return stats;
        }
        public int getCurrentHp() {
            return currentHp;
        }
        public int getCurrentResource() {
            return currentResource;
        }
        
        public boolean isAlive() {
            return currentHp > 0;
        }   
        public void takeDamage(int damage) {
            int newHp = currentHp - damage;
            currentHp = Math.max(newHp,0);
        }
        public void heal(int amount) {
            int newHp = currentHp + amount;
            currentHp = Math.min(newHp, stats.getMaxHp());
        }
        protected void increaseLevelByOne() {
            this.level += 1;
        }
        public void restoreResource(int amount) {
            currentResource = Math.min(currentResource + amount, stats.getMaxMp());
        }
        public void spendResource(int cost) {
            currentResource = Math.max(currentResource - cost, 0);
        }

        @Override
        public String toString() {
            return "Character{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", stats=" + stats +
                    ", currentHp=" + currentHp +
                    ", currentResource=" + currentResource +
                    '}';
        }
    }
