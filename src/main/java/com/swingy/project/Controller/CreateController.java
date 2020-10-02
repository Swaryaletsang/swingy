package com.swingy.project.Controller;

import com.swingy.project.Model.Hero;
import com.swingy.project.View.ConsoleView;

public class CreateController {
    private ConsoleView cView;
    private Hero hero;

    public CreateController(ConsoleView cView, Hero hero) {
        this.cView = cView;
        this.hero = hero;
    }

}
