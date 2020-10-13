package com.swingy.project.Controller;

import com.swingy.project.CurrentPlayer;
import com.swingy.project.Model.Hero;
import com.swingy.project.Model.HeroBuilder;
import com.swingy.project.Model.PlayerModel;
import com.swingy.project.Model.GameComponents.Narator;
import com.swingy.project.View.ConsoleView;
import com.swingy.project.View.GUI;

import lombok.Getter;

import java.awt.event.*;

public class CreateController {
    // private ConsoleView cView;
    public static Hero hero;
    private GUI ui;
    private PlayerModel theModel;
    TransitionManager tm;

    public CreateController(GUI ui, PlayerModel theModel) {
        this.ui = ui;
        this.theModel = theModel;

        this.ui.createBtnListener(new listenToCreateBtn());
        tm = new TransitionManager(ui);
    }

    /**
     * InnerCreateController
     */
    public class listenToCreateBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            String choice = arg0.getActionCommand();
            if (choice.equals("create")) {
                tm.hideCreatePanel();
            }
            
            try {
                hero = new HeroBuilder()
                .setName(ui.getName())
                .setArmor("armor")
                .setWeapon("knife")
                .setAttack(20)
                .setDefence(30)
                .setExperience(124)
                .setHitPoints(100)
                .setLevel(1).getHero();
                System.out.println(hero.toString());
                Narator narator = new Narator(hero,null, ui);
                // CurrentPlayer cp = new CurrentPlayer(hero);
                narator.defaultSetup();
                //save to database
              //theModel.createNewPlayer(hero); 
            } catch (Exception e) {
                //TODO: handle exception
                ui.checkErr("Please enter name");
            }

        }
    
        
    }

}
