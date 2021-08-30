/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogodavelha_v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Celso Franca Neto
 */
public class GameFrame extends JFrame {

    private JogoDaVelha game;
    private JPanel gamePainel;
    private JLabel infoPlayer;
    private GameButton[][] gameButtons;
    private JPanel options;
    private ExitButton exitButton;
    private CleanerButton cleanerButton;
    private JPanel geral;

    public GameFrame() {
        this.game = new JogoDaVelha();
        this.gamePainel = new JPanel(new GridLayout(3, 3, 10, 10));
        this.infoPlayer = new JLabel("Jogador: " + game.seasonPlayer);
        this.gameButtons = new GameButton[3][3];
        this.options = new JPanel(new GridLayout(1, 1, 10, 10));
        this.exitButton = new ExitButton();
        this.cleanerButton = new CleanerButton(game,gameButtons,infoPlayer);
        this.geral = new JPanel(new BorderLayout());
        frameConfig();
        contentConfig();

    }

    public void frameConfig() {
        setTitle("Jogo da Velha");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void contentConfig() {
        geral.add(BorderLayout.CENTER, gamePainel);
        geral.add(BorderLayout.SOUTH, options);
        options.setBorder(new EmptyBorder(10, 10, 10, 10));
        geral.setBorder(new EmptyBorder(50, 100, 100, 100));
        infoPlayer.setBorder(new EmptyBorder(20, 10, 10, 10));
        add(BorderLayout.CENTER, geral);
        add(BorderLayout.NORTH, infoPlayer);
        options.add(cleanerButton);
        options.add(exitButton);
        buttonsConfig();
        infoPlayer.setFont(new Font("Arial", Font.BOLD, 20));
        infoPlayer.setHorizontalAlignment(SwingConstants.CENTER);
        infoPlayer.setForeground(Color.RED);
    }

    public void buttonsConfig() {
        int position = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameButton gameButton = new GameButton(game, infoPlayer,gameButtons);
                this.gameButtons[i][j] = gameButton;
                this.gameButtons[i][j].position = position;
                gamePainel.add(gameButtons[i][j]);
                position++;
            }
        }
        exitButton.setBackground(Color.WHITE);
        cleanerButton.setBackground(Color.WHITE);
    }
}
