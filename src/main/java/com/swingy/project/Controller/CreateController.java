package com.swingy.project.Controller;

import com.swingy.project.CurrentPlayer;
import com.swingy.project.Model.Hero;
import com.swingy.project.Model.HeroBuilder;
import com.swingy.project.Model.Player;
import com.swingy.project.Model.PlayerModel;
import com.swingy.project.Model.GameComponents.Narator;
// import com.swingy.project.View.ConsoleView;
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
                Player player = Player.getInstance();
                player.setName(ui.getName());
                player.setArmor("armor");
                player.setWeapon("knife");
                player.setAttack(20);
                player.setDefence(30);
                player.setExperience(124);
                player.setHitPoints(100);
                player.setLevel(1);
                player.toString();
                theModel.insert();
                Narator narator = new Narator(null, ui);
                narator.defaultSetup();
               
            } catch (Exception e) {
                //TODO: handle exception
                ui.checkErr("Please enter name");
            }

        }
    
        
    }

}
