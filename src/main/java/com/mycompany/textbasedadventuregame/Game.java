package com.mycompany.textbasedadventuregame;

public class Game {
    private Player player;
    private Room currentRoom;
    private boolean isRunning;

    public Game() {
        this.player = new Player(100);
        this.isRunning = true;
        setupWorld();
    }

    private void setupWorld() {
        // Create Rooms
        Room entrance = new Room("Entrance Hall", "A damp, cold stone hallway with torchlight flickering on the walls.");
        Room guardRoom = new Room("Guard Room", "An abandoned guard room scattered with broken wooden chairs.");
        Room armory = new Room("Armory", "A small storage room filled with weapon racks and old iron chests.");
        Room courtyard = new Room("Courtyard", "Fresh night air greets you! The night sky stretches above.");

        // Connect Exits
        entrance.setExit("north", guardRoom);
        
        guardRoom.setExit("south", entrance);
        guardRoom.setExit("east", armory);
        guardRoom.setExit("north", courtyard);

        armory.setExit("west", guardRoom);

        // Add Items
        entrance.addItem(new Item("Key", "A rusty iron key with sharp teeth."));
        armory.addItem(new Item("Potion", "A small glass vial filled with a glowing red liquid.", true));
        armory.addItem(new Item("Map", "A dusty parchment showing the dungeon layout."));

        // Set Starting Room
        currentRoom = entrance;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Player getPlayer() {
        return player;
    }

    public void displayCurrentState() {
        currentRoom.printDetails();
        System.out.println("\n[Health: " + player.getHealth() + "/" + player.getMaxHealth() + "]");
        System.out.print("> ");
    }

    public void processCommand(String input) {
        if (input.isEmpty()) return;

        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String target = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "go":
            case "move":
                handleMove(target);
                break;
            case "take":
            case "get":
                handleTake(target);
                break;
            case "use":
                handleUse(target);
                break;
            case "inventory":
            case "inv":
                player.printInventory();
                break;
            case "look":
                break;
            case "help":
                printHelp();
                break;
            case "quit":
            case "exit":
                System.out.println("Thanks for playing!");
                isRunning = false;
                break;
            default:
                System.out.println("I don't understand that command. Type 'help' for options.");
        }

        if (currentRoom.getName().equalsIgnoreCase("Courtyard")) {
            System.out.println("\nCongratulations! You escaped the dungeon!");
            isRunning = false;
        }
    }

    private void handleMove(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Which direction? (e.g., 'go north')");
            return;
        }

        if (currentRoom.getName().equalsIgnoreCase("Guard Room") && direction.equalsIgnoreCase("north")) {
            if (!player.hasItem("Key")) {
                System.out.println("The northern gate is firmly locked! You need a Key to open it.");
                player.takeDamage(10);
                System.out.println("You strained yourself against the iron door! (-10 HP)");
                return;
            } else {
                System.out.println("You unlock the heavy gate using the rusty Key!");
            }
        }

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void handleTake(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Take what?");
            return;
        }

        Item item = currentRoom.removeItem(itemName);
        if (item != null) {
            player.addItem(item.getName());
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    private void handleUse(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Use what?");
            return;
        }

        if (!player.hasItem(itemName)) {
            System.out.println("You don't have a " + itemName + " in your inventory.");
            return;
        }

        if (itemName.equalsIgnoreCase("potion")) {
            player.heal(30);
            player.removeItem("potion");
            System.out.println("You drank the Potion and restored 30 HP!");
        } else {
            System.out.println("You can't use that right now.");
        }
    }

    private void printHelp() {
        System.out.println("\n--- Commands ---");
        System.out.println("- go [direction]  : Move (north, south, east, west)");
        System.out.println("- take [item]     : Pick up an item from the room");
        System.out.println("- use [item]      : Use a consumable item from your inventory");
        System.out.println("- inventory       : Inspect items you are carrying");
        System.out.println("- look            : Inspect your current surroundings");
        System.out.println("- quit            : Exit the game");
    }
}