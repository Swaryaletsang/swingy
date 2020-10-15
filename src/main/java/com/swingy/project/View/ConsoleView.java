package com.swingy.project.View;

import java.util.Scanner;

import javax.validation.constraints.NotEmpty;

import com.swingy.project.Model.Player;
import com.swingy.project.Model.PlayerModel;

public class ConsoleView {

    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    
    Player player = Player.getInstance();
    PlayerModel theModel;
    story storyObj = new story();

    public ConsoleView(PlayerModel model) {
        this.theModel = model;
    }

    private void createHero() {
        System.out.println("\n*********************************\n");
        System.out.println("Creating new player");
        System.out.print("Name: ");
        @NotEmpty
        String name = scan.nextLine();
        System.out.println("\n*********************************\n");
        

        player.setName(name);
        player.setArmor("armor");
        player.setWeapon("knife");
        player.setAttack(20);
        player.setDefence(30);
        player.setExperience(124);
        player.setHitPoints(100);
        player.setLevel(1);
        player.toString();
        playGame();

    }

    private void playGame() {
        try {
            storyObj.townGate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void choosePlayer() {
        System.out.println("Choosing a player");
    }

    private int startChoice() {
        System.out.println("\n*********************************\n");
        System.out.println("1. CREATE PLAYER\n2. CHOOSE PREVIOUSLY CREATED PLAYER");
        System.out.print("1/2:");
        System.out.println("\n*********************************\n");
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
            System.out.println("press enter to continue....");
            scan2.nextLine();
            initialiseGame();
        }
    }
}
