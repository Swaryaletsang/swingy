package com.swingy.project.Model;

import java.sql.*;
import java.util.*;

import com.mysql.cj.protocol.Resultset;
import com.swingy.project.DBconn;

public class PlayerModel {
    
    //READ (SELECT)
    public List<Hero> getAllPlayers(){
        try {
            List<Hero> heroes = new ArrayList<>();
            PreparedStatement ps = DBconn.getConnection().prepareStatement("SELECT * FROM heroes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //check if i might need ID in the future
               Hero h = new HeroBuilder()
               .setName(rs.getString("Name"))
               .setID(rs.getInt("id"))
               .setArmor(rs.getString("armor"))
               .setAttack(rs.getInt("attack"))
               .setDefence(rs.getInt("defence"))
               .setWeapon(rs.getString("weapon"))
               .setHitPoints(rs.getInt("hp"))
               .setExperience(rs.getInt("experience"))
               .setLevel(rs.getInt("level"))
               .getHero();
               heroes.add(h);
               System.out.println(h.toString());
            }
            return heroes;
        } catch (Exception e) {
            return null;
        }
    }

    public Hero getCurrentByID(int id){
        try {
            Hero h = null;
            PreparedStatement ps = DBconn.getConnection().prepareStatement(
                "SELECT * FROM heroes WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //check if i might need ID in the future
                h = new HeroBuilder()
               .setName(rs.getString("Name"))
               .setID(rs.getInt("id"))
               .setArmor(rs.getString("armor"))
               .setAttack(rs.getInt("attack"))
               .setDefence(rs.getInt("defence"))
               .setWeapon(rs.getString("weapon"))
               .setHitPoints(rs.getInt("hp"))
               .setExperience(rs.getInt("experience"))
               .setLevel(rs.getInt("level"))
               .getHero();
               System.out.println(h.toString());
            }
            return h;
        } catch (Exception e) {
            return null;
        }
    }

    public void createNewPlayer(Hero hero){

        Connection conn = null;
        Statement stmt = null;
        try {
          conn = DBconn.getConnection();
          stmt = conn.createStatement();
          stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS Swingy");
          stmt.executeUpdate("USE swingy");
          stmt.executeUpdate(DBconn.getEMPLOYEE_TABLE());
          stmt.executeUpdate("INSERT INTO heroes(Name, weapon, armor, hp, level, experience, attack, defence) VALUES("+hero.getName()+","+hero.getWeapon()+","+hero.getArmor()+","+hero.getHitPoints()+","+hero.getLevel()+","+hero.getExperience()+","+hero.getAttack()+","+hero.getDefence()+")");
        //   stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(200, 'B')");
        //   System.out.println("CreateEmployeeTableMySQL: main(): table created.");
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
        // Connection conn = null;

        // try {
        //     PreparedStatement ps = DBconn.getConnection().prepareStatement(
        //         "INSERT INTO heroes(Name, weapon, armor, hp, level, experience, attack, defence) VALUES(swary,knife,armor,20,100,12,16,23)");
        //     // ps.setString(1, hero.getName());
        //     // System.out.println(hero.getName());
        //     // ps.setString(2, hero.getWeapon());
        //     // ps.setString(3, hero.getArmor());
        //     // ps.setInt(4, hero.getHitPoints());
        //     // ps.setInt(5, hero.getLevel());
        //     // ps.setInt(6, hero.getExperience());
        //     // ps.setInt(7, hero.getAttack());
        //     // ps.setInt(8, hero.getDefence());
        //     return (ps.executeUpdate() > 0);

        //     //using statement
        //     //return (ps.executeUpdate("INSERT INTO heroes VALUES("+hero.getName()+","+hero.getWeapon()+","+hero.getArmor()+","+hero.getHitPoints()+","+hero.getLevel()+","+hero.getExperience()+","+hero.getAttack()+","+hero.getDefence()+")") > 0);

        // }catch (ClassNotFoundException e) {
        //     System.out.println("error: failed to load MySQL driver.");
        //     e.printStackTrace();
        //   } catch (SQLException e) {
        //     System.out.println("error: failed to create a connection object.");
        //     e.printStackTrace();
        //   } catch (Exception e) {
        //     System.out.println("other error:");
        //     e.printStackTrace();
        //   } finally {
        //     try {
        //       conn.close();
        //     } catch (Exception e) {
        //       e.printStackTrace();
        //      }
        //    }
        //    return false;
        // }

    public Boolean updatePlayer(Hero hero){

        try {
            PreparedStatement ps = DBconn.getConnection().prepareStatement(
                "UPDATE heroes SET Name=? weapon=?, armor=?, hp=?, level=?, experince=?, attack=?,defence=? WHERE id=?");
            ps.setString(1, hero.getName());
            ps.setString(2, hero.getWeapon());
            ps.setString(3, hero.getArmor());
            ps.setInt(4, hero.getHitPoints());
            ps.setInt(5, hero.getLevel());
            ps.setInt(6, hero.getExperience());
            ps.setInt(7, hero.getAttack());
            ps.setInt(8, hero.getDefence());
            ps.setInt(9, hero.getId());
            return (ps.executeUpdate() > 0);
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }
}
