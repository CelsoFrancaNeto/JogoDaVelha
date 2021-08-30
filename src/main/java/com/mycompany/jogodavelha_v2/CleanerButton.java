/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogodavelha_v2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Celso Franca Neto
 */
public class CleanerButton extends JButton {

    public CleanerButton(JogoDaVelha game, JButton[][] gameButtons,JLabel infoPlayer) {
        setText("Limpar");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        game.table[i][j] = "";
                        gameButtons[i][j].setIcon(null);
                        gameButtons[i][j].setEnabled(true);
                        game.seasonPlayer = 1;
                        infoPlayer.setText("Jogador: "+game.seasonPlayer);
                        infoPlayer.setForeground(Color.RED);
                        
                    }
                }
            }
        });
        {
        }
    }
}
