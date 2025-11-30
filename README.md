# 🎮 RPG Game (Java + JavaFX)

A mini World of Warcraft–like RPG built in Java using JavaFX, designed to practice Object-Oriented Programming, clean architecture, and scalable game design.

## This project includes:

🧙 Character Classes

📜 Stats & Derived Combat Values

👤 Player Character Creation

🛡 Combat Engine (in progress)

🧩 Modular architecture inspired by real game studios

🚀 Features (Current)
## ✔ Character Creation

You can create a character by choosing a name and selecting a class:

Warrior

Mage

Rogue

Priest

Ranger

## Each class has unique starting Stats:

Strength

Agility

Intelligence

Stamina

Spirit

## With derived stats like:

Max HP

Max MP

Armor

Attack Power

Spell Power

Crit Chance

## ✔ Game Architecture

Organized into clean layers:

app/          → Game orchestration
domain/       → Pure game logic (no UI)
  character/  
  ability/
  combat/
  npc/
  item/
  quest/
  world/
ui/           → JavaFX screens & controllers
infrastructure/ → persistence & config (future)

## 🛠️ Technologies

Java 21

JavaFX 21

Maven

IntelliJ IDEA

Modular architecture for real-game scalability

## 📦 How to Run
Option 1 — IntelliJ

Simply click Run on the Main class.

Option 2 — Maven

Run from terminal:

mvn clean javafx:run

## 📚 Project Goals

✔ Learn clean OOP architecture
✔ Build a playable RPG prototype
✔ Separate UI from game logic
✔ Allow future features:

Enemy system

Combat engine

Abilities (Fireball, Backstab…)

Inventory & equipment

Quest system

Save/load system (JSON)

🚧 Upcoming Features (Roadmap)

🧟 Enemy system (Goblin, Skeleton…)

⚔ Battle screen with turn-based attacks

✨ Abilities & spells

🧪 Damage formulas & crit logic

🎒 Inventory + items + loot

🌍 Small world exploration

💾 Save/load player data
