package com.swingy.project.Model.GameComponents;


import com.swingy.project.Controller.TransitionManager;
import com.swingy.project.Model.Hero;
import com.swingy.project.View.GUI;

public class Narator {
    GUI theView;
    TransitionManager tm;

    public Narator(GUI theView){
        this.theView = theView;
    }

    public void defaultSetup(Hero hero){
        theView.hpNumlbl.setText("" + hero.getHitPoints());
        theView.weapNamelbl.setText(hero.getWeapon());
    }

    public void selectedPosition(String position){
        switch (position) {
            case "talk": talk(); break;
            case "attack Guard": attackGuard(); break;
            case "leave": leave(); break;
        
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

    }
    public void talk(){

    }
    public void attackGuard(){

    }
    public void leave(){

    }
    
}
