/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textbasedadventuregame;

/**
 *
 * @author docto
 */
public class Item {
    private String name;
    private String description;
    private boolean isUsable;
    
    public Item(String name,String description,boolean isUsable){
        this.name=name;
        this.description=description;
        this.isUsable=isUsable;
    }
    // Overloaded constructor for standard non-usable items (like key, note, coin)
    public Item(String name, String description) {
        this(name, description, false);
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public boolean isUsable(){
        return this.isUsable;
    }
    // Utility method to compare item names without worrying about uppercase/lowercase
    public boolean matches(String itemName) {
        return this.name.equalsIgnoreCase(itemName.trim());
    }
    @Override
    public String toString() {
        return name + " - " + description;
    }
}
