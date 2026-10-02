/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.textbasedadventuregame;
import java.util.Scanner;
/**
 *
 * @author docto
 */
public class TextBasedAdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("========================================");
        System.out.println("      WELCOME TO DUNGEON ESCAPE        ");
        System.out.println("========================================");
        System.out.println("Type 'help' to view available commands.\n");

        // Main game loop driven by input from the Scanner
        while (game.isRunning() && game.getPlayer().isAlive()) {
            game.displayCurrentState();
            
            String userInput = scanner.nextLine().trim().toLowerCase();
            game.processCommand(userInput);
        }

        if (!game.getPlayer().isAlive()) {
            System.out.println("\nGame Over! You succumbed to the dungeon...");
        }

        scanner.close(); // Clean up Scanner resource when the application exits
    }
}

