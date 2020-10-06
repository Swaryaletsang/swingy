package com.swingy.project;

import com.swingy.project.Controller.GameController;
import com.swingy.project.View.GUI;


public class Main 
{
    public static void main( String[] args ) throws Exception
    {
        GUI theView = new GUI();
        // v.createUI();
        GameController controller = new GameController(theView);
        //JFrame frame = new GUI_VIEW("RPG GAME");
        //frame.setVisible(true);
//        CalculatorView theView = new CalculatorView();
//        theView.setVisible(true);
//        DBconn.databaseCon();
//        ConsoleView view = new ConsoleView();
//
//        view.initialiseGame();
    }
}
