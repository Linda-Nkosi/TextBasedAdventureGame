/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedadventuregame;
import java.util.ArrayList;


public class Player {
    private int health;
    private int maxHealth;
    private ArrayList<String> inventory;
  
    //Constructor to initialise starting health and inventory
    
    public Player(int maxHealth){
        this.maxHealth=maxHealth;
        this.health=maxHealth;
        this.inventory=new ArrayList<>();
        
    }
    // --- Health Management ---

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeDamage(int amount) {
        this.health = this.health - amount;
        if (this.health < 0) {
            this.health = 0; // Prevent negative health
        }
    }

    public void heal(int amount) {
        this.health =this.health + amount;
        if (this.health > maxHealth) {
            this.health = maxHealth; // Prevent overhealing past max
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    // --- Inventory Management ---

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void addItem(String item) {
        inventory.add(item);
        System.out.println("Added [" + item + "] to your inventory.");
    }

    public boolean removeItem(String item) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equalsIgnoreCase(item)) {
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean hasItem(String item) {
        for (String i : inventory) {
            if (i.equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is currently empty.");
        } else {
            System.out.print("Inventory: ");
            for (String item : inventory) {
                System.out.print("[" + item + "] ");
            }
            System.out.println();
        }
    }
}

