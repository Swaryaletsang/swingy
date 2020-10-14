package com.swingy.project.Model.GameComponents;

import javax.validation.constraints.NotNull;

import com.swingy.project.CurrentPlayer;
import com.swingy.project.Controller.TransitionManager;
import com.swingy.project.Model.Hero;
import com.swingy.project.Model.HeroBuilder;
import com.swingy.project.Model.Player;
import com.swingy.project.View.GUI;

public class Narator {
    GUI theView;
    TransitionManager tm;
    Movement move;
    HeroBuilder hb = HeroBuilder.getInstance();
    @NotNull
    Player player = Player.getInstance();

    public Narator(Movement move, GUI theView){
        this.theView = theView;
        this.move = move;
        // this.hero = hero;
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
    public void attackGuard(){
        System.out.println(player.toString()+"\n Im in attack guard");
        int hp = player.getHitPoints() - 3;
        System.out.println(player.getHitPoints());
        theView.storyTextArea.setText("Guard: Hey don't be stupid\n All the Guards attacked you, you received damage \n\n (You lost 3 HP)");
        player.setHitPoints(hp);
        theView.hpNumlbl.setText(""+ player.getHitPoints());
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
        int att = player.getAttack() + 10;
        System.out.println(player.getAttack());
        theView.storyTextArea.setText("You found a secondary weapon\n Sword Arquired \n\n (You gained attack strength)");
        player.setAttack(att);
        player.setWeapon("sword");
        theView.weapNamelbl.setText(""+ player.getWeapon());
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
        int hp = player.getHitPoints() + 2;
        System.out.println(player.getHitPoints());
        theView.storyTextArea.setText("You found food...\n You ate enough food and rested \n\n (You gained 2 HP)");
        player.setHitPoints(hp);
        theView.hpNumlbl.setText(""+ player.getHitPoints());
        theView.chBtn1.setText("Go south");
        theView.chBtn2.setText("");
        theView.chBtn3.setText("");
        theView.chBtn4.setText("");

        this.move.setPosition1("leave");
        this.move.setPosition2("");
        this.move.setPosition3("");
        this.move.setPosition4("");
    }
}
