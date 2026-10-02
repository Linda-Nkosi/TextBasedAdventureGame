/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedadventuregame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author docto
 */
public class Room {
    private String name;
    private String description;
    
    // The direction-to-room mapping attribute
    private HashMap<String, Room> exits;
    
    // List to hold Item objects located inside this room
    private List<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>(); // Initialise the Map
        this.items = new ArrayList<>(); // Initialise the Item list
    }

    // --- EXIT METHODS ---
    
    // Method to link another room in a specific direction
    public void setExit(String direction, Room neighbor) {
        exits.put(direction.toLowerCase(), neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    // --- ITEM METHODS (Needed by Game.java) ---

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName.trim())) {
                return items.remove(i);
            }
        }
        return null; // Item wasn't found in the room
    }

    // --- GETTERS & DISPLAY ---

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void printDetails() {
        System.out.println("\n=== " + name + " ===");
        System.out.println(description);

        if (!items.isEmpty()) {
            System.out.print("Items here: ");
            for (Item item : items) {
                System.out.print("[" + item.getName() + "] ");
            }
            System.out.println();
        }

        System.out.print("Exits: ");
        for (String exit : exits.keySet()) {
            System.out.print(exit + " ");
        }
        System.out.println();
    }
}