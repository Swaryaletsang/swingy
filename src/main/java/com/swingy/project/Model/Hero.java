package com.swingy.project.Model;

import lombok.*;


public @Getter @ToString class Hero {

    private String name;
    private int id;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;
    private String weapon;
    private String armor;

    public Hero(String name,int id, int level, int experience, int attack, int defence, int hitPoints, String weapon, String armor){
        this.name = name;
        this.id = id;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.armor = armor;
        this.weapon = weapon;
    }

}
