# TextBasedAdventureGame
Dungeon Escape — A text-based adventure game built in Java featuring room exploration, inventory management, dynamic item interactions, and player survival mechanics.
---

## Features

* Room Navigation: Traverse dynamic locations connected via directional exits (`go north`, `go south`, `east`, `west`).
* Inventory Management: Pick up, carry, and drop items (`take`, `drop`, `inventory`).
* Health & Consumables: Track player status and interact with ambient environment objects.
* Separation of Concerns: Clean architecture isolating input parsing (`Main`), core game state (`Game`), room topology (`Room`), and player entities (`Player`).

---

## Game Commands

| Command | Usage | Description |
| :--- | :--- | :--- |
| `go <direction>` | `go north` | Move to an adjacent room |
| `take <item>` | `take key` | Pick up an item from the current room |
| `drop <item>` | `drop key` | Drop an item from your inventory into the room |
| `inventory` / `inv` | `inventory` | Display held items and player status |
| `help` | `help` | View available commands |
| `quit` | `quit` | Exit the game |

---

## How to Run in NetBeans

1. Open NetBeans IDE.
2. Select File > Open Project... and navigate to this repository's root directory.
3. Verify the main class is set to `com.mycompany.textbasedadventuregame.Main` under Project Properties > Run.
4. Press F6 (or click the green Play button) to run the game in the NetBeans Output console.

---

## Project Architecture

com.mycompany.textbasedadventuregame
 ├── Main.java     # User input handling (Scanner) & main entry point
 ├── Game.java     # Primary game loop & command routing
 ├── Player.java   # Player state, health, & inventory list
 ├── Room.java     # Room mapping (HashMap exits) & item list
 └── Item.java     # Representational item properties
