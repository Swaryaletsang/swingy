package com.swingy.project.View;

import java.util.Random;
import java.util.Scanner;

import com.swingy.project.Model.Player;
import com.swingy.project.Model.GameComponents.Enemy;
import com.swingy.project.Model.GameComponents.Vampire;
import com.swingy.project.Model.GameComponents.Weapon;
import com.swingy.project.Model.GameComponents.WeaponSword;

public class story {
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    int choice;
    Player player = Player.getInstance();
    Enemy enemy;

    public void townGate() {
        System.out.println("\n*********************************\n");
        System.out.println("You are at the gate of the town\nA guard is in front of you \n\n What do you do?");
        System.out.println("\n*********************************\n");
        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack the guard");
        System.out.println("3: Leave");
        System.out.println("\n*********************************\n");
        System.out.print("Choice: ");
        choice = scan.nextInt();

        if (choice == 1) {
            if (player.getLevel() <= 1){
                System.out.println("\n*********************************\n");
                System.out.println("Guard: Hey there...\n I Have never seen your face before \n\n only the royal family and warriors allowed");
                System.out.println("\n*********************************\n");

                System.out.print("Press enter to continue.......");
                scan2.nextLine();
                townGate();
            }else {
                System.out.println("\n*********************************\n");
                System.out.println("Guard: Wow I heard you killed the "+enemy.name+" \nYou earned the kings respect\n WELCOME TO THE PALACE ROYAL");
                System.out.println("\n*********************************\n");
            }
        } else if (choice == 2) {
            int hp = player.getHitPoints() - 3;
            System.out.println("\n*********************************\n");
            System.out.println("HP: "+player.getHitPoints());
            System.out.println("Guard: Hey don't be stupid\n All the Guards attacked you, you received damage \n\n (You lost 3 HP)");
            player.setHitPoints(hp);
            System.out.println("HP: "+player.getHitPoints());
            System.out.println("\n*********************************\n");

            System.out.print("Press enter to continue.......");
            scan2.nextLine();
            townGate();
        }else if (choice == 3){
            leave();
        }else{
            System.out.println("wrong entry choose 1,2 or 3");
            System.out.print("Press enter to continue.......");
            scan2.nextLine();
            townGate();
        }

    }

	private void leave() {
        System.out.println("\n*********************************\n");
        System.out.println("You left the palace\n You are in the middle of a 9X9 Grid \n\n South is where the Palace is! What do you want to do?");
        System.out.println("1: Go south");
        System.out.println("2: Go north");
        System.out.println("3: Go east");
        System.out.println("4: Go west");
        System.out.print("Choice: ");
        choice = scan.nextInt();
        System.out.println("\n*********************************\n");

        switch (choice) {
            case 1: townGate(); break;
            case 2: north(); break;
            case 3: east(); break;
            case 4: west(); break;
        
            default: 
                System.out.println("wrong entry\n choose 1,2,3 or 4");
                System.out.print("Press enter to continue.......");
                scan2.nextLine();
                  break;
        }

    }

    private void west() {
        enemy = new Vampire();
        System.out.println("\n*********************************\n");
        System.out.println( "You ran into a"+enemy.name+"in the shadows\n **Enemy stats**\n strength: "+enemy.attack+"\nHP: "+enemy.hp+"\n\n What do you want to do?");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("\n*********************************\n");
        System.out.print("Choice: ");
        choice = scan.nextInt();

        if (choice == 1) {
            fight();
        } else if (choice == 2) {
            leave();
        } else {
            System.out.println("wrong entry\n choose 1,2, or 3");
            System.out.print("Press enter to continue.......");
            scan2.nextLine();
            west();
        }
    }

    private void fight() {
        System.out.println("\n*********************************\n");
        System.out.println("Its time to fight!!!!!\n **Enemy stats**\n strength: "+enemy.attack+"\nHP: "+enemy.hp+"\n\n What do you want to do?");
        System.out.println("1: Attack");
        System.out.println("2: Run");
        System.out.println("\n*********************************\n");

        System.out.print("Choice: ");
        choice = scan.nextInt();

        if (choice == 1) {
            playerAttack();
        } else if (choice == 2) {
            leave();
        } else {
            System.out.println("wrong entry\n choose 1 or 2");
            System.out.print("Press enter to continue.......");
            scan2.nextLine();
            fight();
        }
    }

    private void playerAttack() {
        int playerDamage = new Random().nextInt(player.getAttack());
        System.out.println("\n*********************************\n");
        System.out.println("You attacked the"+enemy.name+" and gave"+playerDamage+" Damages");
        enemy.hp = enemy.hp - playerDamage;
        System.out.println("\n*********************************\n");

        if (enemy.hp > 0) {
            System.out.print("Press enter to continue.......");
            scan2.nextLine();
            enemyAttack();
        } else {
            win();
        }
    }

    private void win() {
        System.out.println("\n*********************************\n");
        System.out.println("You defeated the "+enemy.name+" \n you advance to the next level");
        System.out.println("\n*********************************\n");
        int level = player.getLevel() + 1;

        player.setLevel(level);
        System.out.print("Press enter to continue.......");
        scan2.nextLine();
        townGate();
    }

    private void enemyAttack() {
        int playerHp = player.getHitPoints();
        int enemyDamage = new Random().nextInt(enemy.attack);
        player.setHitPoints(playerHp - enemyDamage);
        System.out.println("\n*********************************\n");
        System.out.println("The"+enemy.name+" attacked and gave"+enemyDamage+" Damages");
        System.out.println("HP: "+player.getHitPoints());
        System.out.println("\n*********************************\n");

        if (player.getHitPoints() > 0) {
            System.out.print("Press enter to continue.......");
            scan2.nextLine();
            playerAttack();
        } else {
            lose();
        }
    }

    private void lose() {
        System.out.println("\n*********************************\n");
        System.out.println("You are dead \n\n ****GAME OVER****");
        System.out.println("\n*********************************\n");
        System.out.print("Press enter to continue.......");
        scan2.nextLine();
        System.out.println("GOODBYE THANKS FOR PLAYING THE GAME");
    }

    private void north() {
        System.out.println("\n*********************************\n");
        int hp = player.getHitPoints() + 2;
        System.out.println("HP: "+player.getHitPoints());
        player.setHitPoints(hp);
        System.out.println("You found food...\n You ate enough food and rested \n\n (You gained 2 HP)");
        System.out.println("HP: "+player.getHitPoints());
        System.out.println("\n*********************************\n");
        System.out.println("1: Go back to the road");
        System.out.print("Choice: ");
        choice = scan.nextInt();

        if (choice == 1) {
            leave();
        }else {
            north();
        }
    }

    private void east() {
        System.out.println("\n*********************************\n");
        Weapon weapon = new WeaponSword();
        int att = player.getAttack() + weapon.attack;
        System.out.println("You found a secondary weapon\n Sword Arquired \n\n (You gained attack strength)");
        player.setAttack(att);
        player.setWeapon(weapon.name);
        System.out.println("Weapon: "+ player.getWeapon());
        System.out.println("Attack: "+player.getAttack());
        System.out.println("\n*********************************\n");

        System.out.println("1: Go back to the road");
        System.out.print("Choice: ");
        choice = scan.nextInt();

        if (choice == 1) {
            leave();
        }else {
            east();
        }
    }
    
}
