package com.swingy.project.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame{
    JFrame window;
    JPanel titleNamePanel, startBtnJPanel;
    JLabel titleNameLJLabel;
    JButton startButton;

    public void createUI(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setVisible(true);
    }
}
