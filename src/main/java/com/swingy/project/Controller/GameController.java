package com.swingy.project.Controller;

import java.awt.event.*;
import com.swingy.project.Model.GameComponents.Movement;
import com.swingy.project.Model.GameComponents.Narator;
import com.swingy.project.View.GUI;

public class GameController {
    private GUI theView;
    ChoiceHandler cHandler = new ChoiceHandler();
    TransitionManager tm;
    Narator narator;
    Movement move = new Movement();

    // private GameModel data;

    public GameController(GUI theView) {
        this.theView = theView;
        this.theView.createUI(cHandler);
        tm = new TransitionManager(theView);
        tm.showStartScreen();
        this.narator = new Narator(move,theView);
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            String yourChoice = arg0.getActionCommand();
            switch (yourChoice) {
                case "start":
                        tm.showGameScreen();
                        narator.townGate();
                    break;
                case "b1":
                        narator.selectedPosition(move.getPosition1());
                    break;
                case "b2":
                        narator.selectedPosition(move.getPosition2());
                    break;
                case "b3":
                        narator.selectedPosition(move.getPosition3());
                    break;
                case "b4":
                        narator.selectedPosition(move.getPosition4());
                    break;
            
                default:
                    break;
            }
        }

    }
}
