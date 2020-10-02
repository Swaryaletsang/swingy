package com.swingy.project.Model;

import lombok.Getter;

@Getter
public class Hero {

    private String name;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;
    private String weapon;
    private String armor;

    public Hero(String name, int level, int experience, int attack, int defence, int hitPoints, String weapon, String armor){
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.armor = armor;
        this.weapon = weapon;
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }

    public int getExperience(){
        return this.experience;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getDefence(){
        return this.defence;
    }

    public int getHitPoints(){
        return this.hitPoints;
    }

    public String getWeapon(){
        return this.weapon;
    }

    public String getArmor(){
        return this.armor;
    }

}
