package com.swingy.project;

import java.sql.*;

import lombok.Getter;

public class DBconn {
    private static final @Getter String EMPLOYEE_TABLE = "create table IF NOT EXISTS Heroes ( "
      + "   id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(20), weapon VARCHAR(20), "
      + "   armor VARCHAR(20), hp INT, level INT, experience INT, attack INT, defence INT)";
    
    public static Connection getConnection() throws Exception {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
    }

    public static void databaseCon() {
        Connection conn = null;
        Statement stmt = null;
        try {
          conn = getConnection();
          stmt = conn.createStatement();
          stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS Swingy");
          stmt.executeUpdate("USE swingy");
          stmt.executeUpdate(EMPLOYEE_TABLE);
          stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(100, 'A')");
        //   stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(200, 'B')");
          System.out.println("CreateEmployeeTableMySQL: main(): table created.");
            } catch (ClassNotFoundException e) {
          System.out.println("error: failed to load MySQL driver.");
          e.printStackTrace();
        } catch (SQLException e) {
          System.out.println("error: failed to create a connection object.");
          e.printStackTrace();
        } catch (Exception e) {
          System.out.println("other error:");
          e.printStackTrace();
        } finally {
          try {
            stmt.close();
            conn.close();
          } catch (Exception e) {
            e.printStackTrace();
           }
         }
        }
    }