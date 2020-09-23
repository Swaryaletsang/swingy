package com.swingy.project;

import java.sql.*;

import org.slf4j.*;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306";
            String username = "root";

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, "");

            System.out.println("connection successfulllllllll");
        } catch (Exception e) {
            //TODO: handle exception
            e.getStackTrace();
        }
        // Logger log = LoggerFactory.getLogger(Main.class);

        // if (args[0].equals("console")) {
        //     //simulate console view (while loop)
        // } else if (args[0].equals("gui")) {
        //     // simulate GUI view (while loop)
        // }
        //  else {
        //     //error message
        //     log.info("Invalid: Specify CONSOLE or GUI");
        // }
    }
}
