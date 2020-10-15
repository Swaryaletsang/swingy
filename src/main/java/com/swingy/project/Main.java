package com.swingy.project;

import com.swingy.project.Controller.CreateController;
import com.swingy.project.Controller.GameController;
import com.swingy.project.Model.PlayerModel;
import com.swingy.project.View.ConsoleView;
import com.swingy.project.View.GUI;


public class Main 
{
    public static void main( String[] args ) throws Exception
    {
        PlayerModel model = new PlayerModel();
        if (args.length == 1) {
        
            if (args[0].equals("console")) {
                ConsoleView console = new ConsoleView(model);
                console.initialiseGame();
            } else if(args[0].equals("gui")) {
                GUI theView = new GUI();
                GameController controller = new GameController(theView);
                CreateController create = new CreateController(theView, model);
            
            }else{
                System.out.println("Come on give an argument (gui or console)");
            }
        }else {
            System.out.println("argument error ");
        }
    }
}
