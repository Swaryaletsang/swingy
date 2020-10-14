package com.swingy.project.Model;

import java.sql.*;
import com.swingy.project.Model.*;

public class PlayerModel {
    static Player player = Player.getInstance();

    // // READ (SELECT)
    // public List<Hero> getAllPlayers() {
    //     try {
    //         List<Hero> heroes = new ArrayList<>();
    //         PreparedStatement ps = DBconn.getConnection().prepareStatement("SELECT * FROM heroes");
    //         ResultSet rs = ps.executeQuery();
    //         while (rs.next()) {
    //             // check if i might need ID in the future
    //             // Hero h = new HeroBuilder()
    //             Hero h = HeroBuilder.getInstance().setName(rs.getString("Name")).setID(rs.getInt("id"))
    //                     .setArmor(rs.getString("armor")).setAttack(rs.getInt("attack")).setDefence(rs.getInt("defence"))
    //                     .setWeapon(rs.getString("weapon")).setHitPoints(rs.getInt("hp"))
    //                     .setExperience(rs.getInt("experience")).setLevel(rs.getInt("level")).getHero();
    //             heroes.add(h);
    //             System.out.println(h.toString());
    //         }
    //         return heroes;
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

    // public Hero getCurrentByID(int id) {
    //     try {
    //         Hero h = null;
    //         PreparedStatement ps = DBconn.getConnection().prepareStatement("SELECT * FROM heroes WHERE id=?");
    //         ps.setInt(1, id);
    //         ResultSet rs = ps.executeQuery();
    //         while (rs.next()) {
    //             // check if i might need ID in the future
    //             // h = new HeroBuilder()
    //             h = HeroBuilder.getInstance().setName(rs.getString("Name")).setID(rs.getInt("id"))
    //                     .setArmor(rs.getString("armor")).setAttack(rs.getInt("attack")).setDefence(rs.getInt("defence"))
    //                     .setWeapon(rs.getString("weapon")).setHitPoints(rs.getInt("hp"))
    //                     .setExperience(rs.getInt("experience")).setLevel(rs.getInt("level")).getHero();
    //             System.out.println(h.toString());
    //         }
    //         return h;
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

    public void insert() {
        try {
            Connection conn = DBMS.connect();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO heroes(Name, weapon, armor, hp, level,attack, experience, defence) VALUES(?,?,?,?,?,?,?,?)");
            ps.setString(1, player.getName());
            System.out.println(player.getName());
            ps.setString(2, player.getWeapon());
            ps.setString(3, player.getArmor());
            ps.setInt(4, player.getHitPoints());
            ps.setInt(5, player.getLevel());
            ps.setInt(6, player.getAttack());
            ps.setInt(7, player.getExperience());
           
            ps.setInt(8, player.getDefence());
            ps.execute();

        }catch (ClassNotFoundException e) {
            System.out.println("error: failed to load MySQL driver.");
            e.printStackTrace();
          } catch (SQLException e) {
            System.out.println("error: failed to create a connection object.");
            e.printStackTrace();
          } catch (Exception e) {
            System.out.println("other error:");
           }
        }

    // public Boolean updatePlayer(Hero hero){

    //     try {
    //         PreparedStatement ps = DBconn.getConnection().prepareStatement(
    //             "UPDATE heroes SET Name=? weapon=?, armor=?, hp=?, level=?, experince=?, attack=?,defence=? WHERE id=?");
    //         ps.setString(1, hero.getName());
    //         ps.setString(2, hero.getWeapon());
    //         ps.setString(3, hero.getArmor());
    //         ps.setInt(4, hero.getHitPoints());
    //         ps.setInt(5, hero.getLevel());
    //         ps.setInt(6, hero.getExperience());
    //         ps.setInt(7, hero.getAttack());
    //         ps.setInt(8, hero.getDefence());
    //         ps.setInt(9, hero.getId());
    //         return (ps.executeUpdate() > 0);
    //     } catch (Exception e) {
    //         
    //         return false;
    //     }
    // }
}
