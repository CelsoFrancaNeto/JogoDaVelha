/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogodavelha_v2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Celso Franca Neto
 */
public class GameButton extends JButton {

    public int position;

    public GameButton(JogoDaVelha game, JLabel infoPlayer, JButton[][] gameButtons) {
        this.position = 0;

        setBackground(Color.WHITE);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (game.seasonPlayer == 1) {
                    setIcon(new javax.swing.ImageIcon("X.png"));
                    setDisabledIcon(new javax.swing.ImageIcon("X.png"));
                    game.play(position, game.seasonPlayer);
                    System.out.println(position + " : " + game.seasonPlayer);
                    System.out.println("Winner: " + game.verifyWinner());
                    infoPlayer.setForeground(Color.BLUE);
                    setEnabled(false);
                    infoPlayer.setText("Jogador: " + 2);
                    winCase(game, infoPlayer, gameButtons);
                    drawCase(game, infoPlayer);
                    game.seasonPlayer = 2;

                } else if (game.seasonPlayer == 2) {
                    setIcon(new javax.swing.ImageIcon("O.png"));
                    setDisabledIcon(new javax.swing.ImageIcon("O.png"));
                    game.play(position, game.seasonPlayer);
                    System.out.println(position + " : " + game.seasonPlayer);
                    System.out.println("Winner: " + game.verifyWinner());
                    infoPlayer.setForeground(Color.RED);
                    setEnabled(false);
                    infoPlayer.setText("Jogador: " + 1);
                    winCase(game, infoPlayer, gameButtons);
                    drawCase(game, infoPlayer);
                    game.seasonPlayer = 1;

                }

            }

        });
    }

    public void winCase(JogoDaVelha game, JLabel infoPlayer, JButton[][] gameButtons) {
        if (game.verifyWinner() != "NotWinnerYet") {

            infoPlayer.setText("O Jogador " + game.seasonPlayer + " Venceu!");
            if (game.seasonPlayer == 1) {
                infoPlayer.setForeground(Color.RED);
            } else {
                infoPlayer.setForeground(Color.BLUE);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    gameButtons[i][j].setEnabled(false);
                }
            }
        }
    }

    public void drawCase(JogoDaVelha game, JLabel infoPlayer) {
        int full = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.table[i][j] != "") {
                    full++;
                }
            }
        }
        if (full == 9 && game.verifyWinner() == "NotWinnerYet") {
            infoPlayer.setText("Empate!");
            infoPlayer.setForeground(Color.BLACK);

        }
    }

}
