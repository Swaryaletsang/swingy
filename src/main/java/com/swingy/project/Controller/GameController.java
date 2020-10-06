package com.swingy.project.Controller;

import java.awt.event.*;

import com.swingy.project.View.GUI;

public class GameController {
    private GUI theView;
    ChoiceHandler cHandler = new ChoiceHandler();
    TransitionManager tm;

    // private GameModel data;

    public GameController(GUI theView) {
        this.theView = theView;
        this.theView.createUI(cHandler);
        tm = new TransitionManager(theView);
        tm.showStartScreen();

    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            String yourChoice = arg0.getActionCommand();
            switch (yourChoice) {
                case "start":
                        tm.showGameScreen();
                    break;
                case "b1":
                    //tm.showGameScreen();
                    break;
                case "b2":
                        //tm.showGameScreen();
                    break;
                case "b3":
                        //tm.showGameScreen();
                    break;
                case "b4":
                        //tm.showGameScreen();
                    break;
            
                default:
                    break;
            }
        }

    }
}