package com.swingy.project.Controller;

import com.swingy.project.Model.Hero;
import com.swingy.project.Model.HeroBuilder;
import com.swingy.project.Model.PlayerModel;
import com.swingy.project.View.ConsoleView;
import com.swingy.project.View.GUI;
import java.awt.event.*;

public class CreateController {
    // private ConsoleView cView;
    private Hero hero;
    private GUI ui;
    private PlayerModel theModel;

    public CreateController(GUI ui, PlayerModel theModel) {
        this.ui = ui;
        this.theModel = theModel;

        this.ui.createBtnListener(new listenToCreateBtn());
    }

    /**
     * InnerCreateController
     */
    public class listenToCreateBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
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
               System.out.println(theModel.createNewPlayer(hero)); 
            } catch (Exception e) {
                //TODO: handle exception
                ui.checkErr("Please enter name");
            }

        }
    
        
    }

}
