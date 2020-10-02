package com.swingy.project.View;

import java.util.Scanner;

public class ConsoleView {

    Scanner scan = new Scanner(System.in);
    private String name;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;
    private String weapon;
    private String armor;
    
    private void createHero() {
        String[] weapons = {"GUN", "KNIFE", "SWORD", "BOW & ARROW"};
        String[] Armors = {"BULLETPROOF", "VIBRANIUM", "LEATHER ARMOR", "METAL SHIELD"};

        System.out.println("Creating new player");
        System.out.print("Name: ");
        name = scan.nextLine();
        level = 1;
        experience = 0;
        System.out.print("Choose Weapon: ");
        int w = scan.nextInt();
        System.out.print("Choose Armor: ");
        int a = scan.nextInt();
        hitPoints = 0;


    }

    private void choosePlayer() {
        System.out.println("Choosing a player");
    }

    private int startChoice() {
        System.out.println("1. CREATE PLAYER\n2. CHOOSE PREVIOUSLY CREATED PLAYER");
        System.out.print("1/2:");
        String choice = scan.nextLine();

        if (choice.equals("1"))
            return 1;
        if (choice.equals("2"))
            return 2;
        return 0;
    }

    public void initialiseGame() {
        int choice = startChoice();

        if (choice == 1){
            createHero();
        }else if (choice == 2){
            choosePlayer();
        }else {
            System.out.println("wrong entry");
        }
    }
}
