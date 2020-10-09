package com.swingy.project.Controller;

import com.swingy.project.View.GUI;

public class TransitionManager {
    GUI ui;

    public TransitionManager(GUI ui){
        this.ui = ui;
    }

    public void showStartScreen(){
        //show required [panels]
        this.ui.titleNamePanel.setVisible(true);
        this.ui.startBtnJPanel.setVisible(true);

        //Hide Other panels
        ui.choiceBtnPanel.setVisible(false);
        ui.storyTextPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.CreatePanel.setVisible(false);
    }

    public void showGameScreen(){
        //Hide Other panels
        this.ui.titleNamePanel.setVisible(false);
        this.ui.startBtnJPanel.setVisible(false);

        //show required [panels]
        ui.choiceBtnPanel.setVisible(false);
        ui.storyTextPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.CreatePanel.setVisible(true);
    }

	public void hideCreatePanel() {
        ui.choiceBtnPanel.setVisible(true);
        ui.storyTextPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        // this.ui.titleNamePanel.setVisible(false);
        // this.ui.startBtnJPanel.setVisible(false);
        ui.CreatePanel.setVisible(false);
        System.out.println("Im here");
	}
}
