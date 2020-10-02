package com.swingy.project;

import com.swingy.project.View.ConsoleView;
import com.swingy.project.View.GUI;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) throws Exception
    {
        GUI gui = new GUI();
        gui.createUI();
        CalculatorView theView = new CalculatorView();
        theView.setVisible(true);
        DBconn.databaseCon();
        ConsoleView view = new ConsoleView();

        view.initialiseGame();
    }
}
