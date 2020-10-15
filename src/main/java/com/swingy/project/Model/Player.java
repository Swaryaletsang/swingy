package com.swingy.project.Model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {
    @NotBlank
    private String name;
    private int id;
    private int level;
    private int experience;
    private int attack;
    private int defence;
    private int hitPoints;
    private String weapon;
    private String armor;

    static Player player = new Player();

    private Player(){}

    public static Player getInstance(){
        return player;
    }
}
