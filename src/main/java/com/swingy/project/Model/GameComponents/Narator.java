package com.swingy.project.Model.GameComponents;

import java.util.Random;

import javax.validation.constraints.NotNull;
import com.swingy.project.Controller.TransitionManager;
import com.swingy.project.Model.FileStoreHandler;
import com.swingy.project.Model.Player;
import com.swingy.project.View.GUI;

public class Narator {
    GUI theView;
    TransitionManager tm;
    Movement move;
    @NotNull
    Player player = Player.getInstance();
    Enemy enemy;

    public Narator(Movement move, GUI theView){
        this.theView = theView;
        this.move = move;
    }

    public void defaultSetup(){
        theView.hpNumlbl.setText("" + player.getHitPoints());
        theView.weapNamelbl.setText(player.getWeapon());
        System.out.println(player.toString()+ "\nI'M IN NARATOR");
    }

    public void selectedPosition(String position){
        switch (position) {
            case "townGate": townGate(); break;
            case "talk": talk(); break;
            case "attack": attackGuard(); break;
            case "leave": leave(); break;
            case "north": north(); break;
            case "west": west(); break;
            case "east": east(); break;
            case "fight": fight(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "ending": ending(); break;
            case "playerAttack": playerAttack(); break;
            case "enemyAttack": enemyAttack(); break;
            case "start": start(); break;
            default:
                break;
        }
    }

    public void townGate(){
        theView.storyTextArea.setText("You are at the gate of the town\nA guard is in front of you \n\n What do you do?");
        theView.chBtn1.setText("Talk to the guard");
        theView.chBtn2.setText("Attack the guard");
        theView.chBtn3.setText("Leave");
        theView.chBtn4.setText("");

        this.move.setPosition1("talk");
        this.move.setPosition2("attack");
        this.move.setPosition3("leave");
        this.move.setPosition4("");
    }
    public void talk(){
        if (player.getLevel() <= 1){
            theView.storyTextArea.setText("Guard: Hey there...\n I Have never seen your face before \n\n only the royal family and warriors allowed");
            theView.chBtn1.setText(">");
            theView.chBtn2.setText("");
            theView.chBtn3.setText("");
            theView.chBtn4.setText("");

            this.move.setPosition1("townGate");
            this.move.setPosition2("");
            this.move.setPosition3("");
            this.move.setPosition4("");
        }
        else {
            ending();
        }
    }
    public void attackGuard(){
        System.out.println(player.toString()+"\n Im in attack guard");
        int hp = player.getHitPoints() - 3;
        System.out.println(player.getHitPoints());
        theView.storyTextArea.setText("Guard: Hey don't be stupid\n All the Guards attacked you, you received damage \n\n (You lost 3 HP)");
        player.setHitPoints(hp);
        theView.hpNumlbl.setText(""+ player.getHitPoints());
        FileStoreHandler.update(player.getName());
        theView.chBtn1.setText(">");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");
        System.out.println(player.toString()+"\n Im in attack guard");

        this.move.setPosition1("townGate");
        this.move.setPosition2("");
        this.move.setPosition3("");
        this.move.setPosition4("");
    }
    public void leave(){
        theView.storyTextArea.setText("You left the palace\n You are in the middle of a 9X9 Grid \n\n South is where the Palace is! What do you want to do?");
        theView.chBtn1.setText("Go north");
        theView.chBtn2.setText("Go east");
        theView.chBtn3.setText("Go south");
        theView.chBtn4.setText("Go West");

        this.move.setPosition1("north");
        this.move.setPosition2("east");
        this.move.setPosition3("townGate");
        this.move.setPosition4("west");
    }

    public void north(){
        int hp = player.getHitPoints() + 2;
        System.out.println(player.getHitPoints());
        theView.storyTextArea.setText("You found food...\n You ate enough food and rested \n\n (You gained 2 HP)");
        player.setHitPoints(hp);
        theView.hpNumlbl.setText(""+ player.getHitPoints());
        FileStoreHandler.update(player.getName());
        theView.chBtn1.setText("Go south");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        this.move.setPosition1("leave");
        this.move.setPosition2("");
        this.move.setPosition3("");
        this.move.setPosition4("");
    }
    
    public void east(){
        Weapon weapon = new WeaponSword();
        int att = player.getAttack() + weapon.attack;
        System.out.println(player.getAttack());
        theView.storyTextArea.setText("You found a secondary weapon\n Sword Arquired \n\n (You gained attack strength)");
        player.setAttack(att);
        player.setWeapon(weapon.name);
        theView.weapNamelbl.setText(""+ player.getWeapon());
        FileStoreHandler.update(player.getName());
        theView.chBtn1.setText("Go west");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        this.move.setPosition1("leave");
        this.move.setPosition2("");
        this.move.setPosition3("");
        this.move.setPosition4("");
    }

    public void west(){
        enemy = new Vampire();
        
        theView.storyTextArea.setText(
            "You ran into a"+enemy.name+"in the shadows\n **Enemy stats**\n strength: "+enemy.attack+"\nHP: "+enemy.hp+"\n\n What do you want to do?");
        theView.chBtn1.setText("fight");
        theView.chBtn2.setText("run");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        this.move.setPosition1("fight");
        this.move.setPosition2("leave");
        this.move.setPosition3("");
        this.move.setPosition4("");
    }

    public void fight() {

        theView.storyTextArea.setText(
            "Its time to fight!!!!!\n **Enemy stats**\n strength: "+enemy.attack+"\nHP: "+enemy.hp+"\n\n What do you want to do?");
        theView.chBtn1.setText("attack");
        theView.chBtn2.setText("run");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        this.move.setPosition1("playerAttack");
        this.move.setPosition2("leave");
        this.move.setPosition3("");
        this.move.setPosition4("");
    }

    public void playerAttack(){
        int playerDamage = new Random().nextInt(player.getAttack());

        theView.storyTextArea.setText("You attacked the"+enemy.name+" and gave"+playerDamage+" Damages");
        enemy.hp = enemy.hp - playerDamage;

        theView.chBtn1.setText(">");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        if (enemy.hp > 0){
            this.move.setPosition1("enemyAttack");
            this.move.setPosition2("");
            this.move.setPosition3("");
            this.move.setPosition4("");
        }else if (enemy.hp < 1){
            this.move.setPosition1("win");
            this.move.setPosition2("");
            this.move.setPosition3("");
            this.move.setPosition4("");
        }
    }
    public void enemyAttack(){
        int playerHp = player.getHitPoints();
        int enemyDamage = new Random().nextInt(enemy.attack);
        player.setHitPoints(playerHp - enemyDamage);
        theView.storyTextArea.setText("The"+enemy.name+" attacked and gave"+enemyDamage+" Damages");
        theView.hpNumlbl.setText(""+ player.getHitPoints());
        FileStoreHandler.update(player.getName());

        theView.chBtn1.setText(">");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        if (player.getHitPoints() > 0){

            this.move.setPosition1("fight");
            this.move.setPosition2("");
            this.move.setPosition3("");
            this.move.setPosition4("");
        }else if (player.getHitPoints() < 1){

            this.move.setPosition1("lose");
            this.move.setPosition2("");
            this.move.setPosition3("");
            this.move.setPosition4("");
        }
    }

    public void win(){
        theView.storyTextArea.setText("You defeated the "+enemy.name+" \n you advance to the next level");
        int level = player.getLevel() + 1;

        player.setLevel(level);
        FileStoreHandler.update(player.getName());

        theView.chBtn1.setText("Go east");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        this.move.setPosition1("leave");
        this.move.setPosition2("");
        this.move.setPosition3("");
        this.move.setPosition4("");
    }

    public void lose(){
        theView.storyTextArea.setText("You are dead \n\n ****GAME OVER****");

        theView.chBtn1.setText("New game");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        this.move.setPosition1("start");
        this.move.setPosition2("");
        this.move.setPosition3("");
        this.move.setPosition4("");
        FileStoreHandler.delete(player.getName());
    }

    public void ending(){
        theView.storyTextArea.setText("Guard: Wow I heard you killed the "+enemy.name+" \nYou earned the kings respect\n WELCOME TO THE PALACE ROYAL" );
        theView.chBtn1.setVisible(false);
        theView.chBtn2.setVisible(false);
        theView.chBtn3.setVisible(false);
        theView.chBtn4.setVisible(false);
    }

    public void start(){
        defaultSetup();
        tm.showStartScreen();
    }
}
