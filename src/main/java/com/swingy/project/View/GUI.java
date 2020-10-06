package com.swingy.project.View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.swingy.project.Controller.GameController.ChoiceHandler;

public class GUI {
    /**
     *
     */
    JFrame window;
    public JPanel titleNamePanel, startBtnJPanel, storyTextPanel, choiceBtnPanel, playerPanel, CreatePanel;
    JLabel titleNameLJLabel, hplbl, hpNumlbl, weaponlbl, weapNamelbl, pName, WeapChoice, ArmChoice;
    JButton startButton, chBtn1, chBtn2, chBtn3, chBtn4, btnCreate;
    JTextArea storyTextArea;
    JTextField name;
    JRadioButton w1,w2,w3,a1,a2;
    ButtonGroup a, w;


    public void createUI(ChoiceHandler cHandler) {
        // WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.LIGHT_GRAY);
        window.setLayout(null);

        // TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 500);
        titleNamePanel.setBackground(Color.BLUE);
        titleNameLJLabel = new JLabel("SWINGY RPG");
        titleNameLJLabel.setForeground(Color.BLACK);
        titleNameLJLabel.setFont(new Font("Times New Roman", Font.ITALIC, 85));
        titleNamePanel.add(titleNameLJLabel);

        startBtnJPanel = new JPanel();
        startBtnJPanel.setBounds(300, 400, 200, 100);
        startBtnJPanel.setBackground(Color.BLUE);
        startButton = new JButton("START GAME");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.BLACK);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startBtnJPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startBtnJPanel);

        //Create player panel
        CreatePanel = new JPanel();
        CreatePanel.setBounds(100, 100, 600, 500);
        CreatePanel.setBackground(Color.red);
        window.add(CreatePanel);
        pName = new JLabel("NAME:");
        name = new JTextField(15);
        ArmChoice = new JLabel("Choose Armor:");
        WeapChoice = new JLabel("Choose Weapon:");
        btnCreate = new JButton("Create Player");
        w1 = new JRadioButton("Knife");
        w2 = new JRadioButton("Sword");
        w3 = new JRadioButton("Bow and Arrow");
        w = new ButtonGroup();
        w.add(w1);
        w.add(w2);
        w.add(w3);
        a1 = new JRadioButton("Steel armor");
        a2 = new JRadioButton("Leather armor");
        a = new ButtonGroup();
        a.add(a1);
        a.add(a2);

        CreatePanel.add(pName);
        CreatePanel.add(name);
        CreatePanel.add(WeapChoice);
        CreatePanel.add(w1);
        CreatePanel.add(w2);
        CreatePanel.add(w3);
        CreatePanel.add(ArmChoice);
        CreatePanel.add(a1);
        CreatePanel.add(a2);
        CreatePanel.add(btnCreate);


        // Game play screen
        storyTextPanel = new JPanel();
        storyTextPanel.setBounds(100, 100, 600, 250);
        storyTextPanel.setBackground(Color.CYAN);
        window.add(storyTextPanel);

        storyTextArea = new JTextArea("yhis is the story text area");
        storyTextArea.setBounds(100, 100, 600, 250);
        storyTextArea.setBackground(Color.LIGHT_GRAY);
        storyTextArea.setForeground(Color.BLACK);
        storyTextArea.setLineWrap(true);
        storyTextArea.setWrapStyleWord(true);
        storyTextArea.setEditable(false);
        storyTextPanel.add(storyTextArea);

        choiceBtnPanel = new JPanel();
        choiceBtnPanel.setBounds(250, 350, 300, 150);
        choiceBtnPanel.setBackground(Color.LIGHT_GRAY);
        window.add(choiceBtnPanel);

        chBtn1 = new JButton("FirstChoice");
        chBtn1.setBackground(Color.red);
        chBtn1.setForeground(Color.YELLOW);
        chBtn1.setFocusPainted(false);
        chBtn1.addActionListener(cHandler);
        chBtn1.setActionCommand("b1");
        choiceBtnPanel.add(chBtn1);

        chBtn2 = new JButton("SecondChoice");
        chBtn2.setBackground(Color.red);
        chBtn2.setForeground(Color.YELLOW);
        chBtn2.setFocusPainted(false);
        chBtn2.addActionListener(cHandler);
        chBtn2.setActionCommand("b2");
        choiceBtnPanel.add(chBtn2);

        chBtn3 = new JButton("ThirdChoice");
        chBtn3.setBackground(Color.red);
        chBtn3.setForeground(Color.YELLOW);
        chBtn3.setFocusPainted(false);
        chBtn3.addActionListener(cHandler);
        chBtn3.setActionCommand("b3");
        choiceBtnPanel.add(chBtn3);


        chBtn4 = new JButton("ForthChoice");
        chBtn4.setBackground(Color.red);
        chBtn4.setForeground(Color.YELLOW);
        chBtn4.setFocusPainted(false);
        chBtn4.addActionListener(cHandler);
        chBtn4.setActionCommand("b4");
        choiceBtnPanel.add(chBtn4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 100, 600, 250);
        playerPanel.setBackground(Color.CYAN);
        

        hplbl = new JLabel("HP:");
        hplbl.setForeground(Color.BLACK);
        playerPanel.add(hplbl);
        hpNumlbl = new JLabel();
        hpNumlbl.setForeground(Color.GREEN);
        playerPanel.add(hpNumlbl);
        weaponlbl = new JLabel("Weapon:");
        weaponlbl.setForeground(Color.BLACK);
        playerPanel.add(weaponlbl);
        weapNamelbl = new JLabel();
        weapNamelbl.setForeground(Color.GREEN);
        playerPanel.add(weapNamelbl);
        window.add(playerPanel);

        window.setVisible(true);
    }
}
