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

    public Boolean createNewPlayer(Hero hero){

        try {
            PreparedStatement ps = DBconn.getConnection().prepareStatement(
                "INSERT INTO heroes VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, hero.getName());
            ps.setString(2, hero.getWeapon());
            ps.setString(3, hero.getArmor());
            ps.setInt(4, hero.getHitPoints());
            ps.setInt(5, hero.getLevel());
            ps.setInt(6, hero.getExperience());
            ps.setInt(7, hero.getAttack());
            ps.setInt(8, hero.getDefence());
            return (ps.executeUpdate() > 0);
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }

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
