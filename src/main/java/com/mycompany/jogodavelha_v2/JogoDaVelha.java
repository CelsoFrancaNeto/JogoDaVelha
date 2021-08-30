/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogodavelha_v2;

/**
 *
 * @author Celso Franca Neto
 */
public class JogoDaVelha {

    public String[][] table;
    public int seasonPlayer;

    public JogoDaVelha() {
        this.table = new String[3][3];
        this.seasonPlayer = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.table[i][j] = "";
            }
        }
    }

    private String setPiece(int seasonPlayer) {
        String piece = "";

        if(seasonPlayer == 1) {
            piece = "x";
        }
        else if(seasonPlayer == 2) {
            piece = "o";
        }
        return piece;
    }

    public boolean play(int position, int seasonPlayer) {
        switch (position) {
            case 0:
                this.table[0][0] = setPiece(seasonPlayer);
                return true;
            case 1:
                this.table[0][1] = setPiece(seasonPlayer);
                return true;
            case 2:
                this.table[0][2] = setPiece(seasonPlayer);
                return true;
            case 3:
                this.table[1][0] = setPiece(seasonPlayer);
                return true;
            case 4:
                this.table[1][1] = setPiece(seasonPlayer);
                return true;
            case 5:
                this.table[1][2] = setPiece(seasonPlayer);
                return true;
            case 6:
                this.table[2][0] = setPiece(seasonPlayer);
                return true;
            case 7:
                this.table[2][1] = setPiece(seasonPlayer);
                return true;
            case 8:
                this.table[2][2] = setPiece(seasonPlayer);
                return true;
            default:
                return false;
        }
    }

    public String verifyWinner() {
        String winner = "NotWinnerYet";
        //Verificador de Horizontais
        for (int i = 0; i < 3; i++) {
            if ((this.table[i][0] == this.table[i][1] && this.table[i][0] == this.table[i][2]) && this.table[i][1] != "") {
                winner = this.table[i][0];
            }
        }
        //Verificador de Verticais
        for (int i = 0; i < 3; i++) {
            if ((this.table[0][i] == this.table[1][i] && this.table[0][i] == this.table[2][i]) && this.table[0][i] != "") {
                winner = this.table[0][i];
            }
        }
        //Verificador de Diagonal

        if ((this.table[0][0] == this.table[1][1] && this.table[0][0] == this.table[2][2]) && this.table[0][0] != "") {
            winner = this.table[0][0];
        }
        //Verificador de ContraDiagonal
        
        if ((this.table[0][2] == this.table[1][1] && this.table[0][2] == this.table[2][0]) && this.table[0][2] != "") {
            winner = this.table[0][2];
        }
        
        return winner;
    }

}
