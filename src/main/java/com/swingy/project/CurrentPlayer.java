package com.swingy.project;

import com.swingy.project.Model.Hero;

import lombok.Getter;
@Getter
public class CurrentPlayer {
    Hero hero;
    public CurrentPlayer(Hero hero){
        this.hero = hero;
    }

}
