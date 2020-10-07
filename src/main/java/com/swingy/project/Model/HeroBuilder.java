package com.swingy.project.Model;

import lombok.Setter;

public class HeroBuilder {;
    private String name;
    private int id;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;
    private String weapon;
    private String armor;

    public HeroBuilder setName(String name){
        this.name = name;
        return this;
    }

    public HeroBuilder setID(int id){
        this.id = id;
        return this;
    }

    public HeroBuilder setLevel(int level){
        this.level = level;
        return this;
    }

    public HeroBuilder setExperience(int experience){
        this.experience = experience;
        return this;
    }

    public HeroBuilder setAttack(int  attack){
        this.attack = attack;
        return this;
    }

    public HeroBuilder setDefence(int defence){
        this.defence = defence;
        return this;
    }

    public HeroBuilder setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
        return this;
    }
    
    public HeroBuilder setWeapon(String weapon){
        this.weapon = weapon;
        return this;
    }

    public HeroBuilder setArmor(String armor){
        this.armor = armor;
        return this;
    }

    public Hero getHero(){
        return new Hero(name, id, level, experience, attack, defence, hitPoints, weapon, armor);
    }
}
