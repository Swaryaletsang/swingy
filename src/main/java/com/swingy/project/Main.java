package com.swingy.project;

import com.swingy.project.Controller.CreateController;
import com.swingy.project.Controller.GameController;
import com.swingy.project.Model.PlayerModel;
import com.swingy.project.View.GUI;


public class Main 
{
    public static void main( String[] args ) throws Exception
    {
        //DBconn.databaseCon();
        PlayerModel model = new PlayerModel();
        GUI theView = new GUI();
        GameController controller = new GameController(theView);
        CreateController create = new CreateController(theView, model);

//        theView.setVisible(true);
//        DBconn.databaseCon();
//        ConsoleView view = new ConsoleView();
//
//        view.initialiseGame();
    }
}
