/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 * @author Stegger
 */
public class GameBoard implements IGameModel {
    private int player = 0;
    private int winner;
    private int turn= 0;
    private final String[][] table = new String[3][3];

    public int getNextPlayer() {
        return player;
    }

    public boolean play(int col, int row) {
        if (table[row][col] == null) {
            if (player == 0) {
                table[row][col] = "X";
            } else {
                table[row][col] = "O";
            }

            if (player == 0) {
                player = 1;
            } else {
                player = 0;
            }
            turn++;
            return true;

        } else {
            return false;
        }

    }

    public boolean isGameOver() {
            if (checkWin("X")) {
                winner = 0; // Player 0 (X) wins
                return true;
            } else if (checkWin("O")) {
                winner = 1; // Player 1 (O) wins
                return true;
            } else if (turn == 9) {
                winner = -1; // It's a draw
                return true;
            }
            return false;
        }




        private boolean checkWin(String symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((table[i][0] != null && table[i][0].equals(symbol) && table[i][1] != null && table[i][1].equals(symbol) && table[i][2] != null && table[i][2].equals(symbol)) ||
                    (table[0][i] != null && table[0][i].equals(symbol) && table[1][i] != null && table[1][i].equals(symbol) && table[2][i] != null && table[2][i].equals(symbol))) {
                return true;
            }
        }

        // Check diagonals
        if ((table[0][0] != null && table[0][0].equals(symbol) && table[1][1] != null && table[1][1].equals(symbol) && table[2][2] != null && table[2][2].equals(symbol)) ||
                (table[0][2] != null && table[0][2].equals(symbol) && table[1][1] != null && table[1][1].equals(symbol) && table[2][0] != null && table[2][0].equals(symbol))) {
            return true;
        }

        return false;
    }
    public int getWinner() {
        return winner;
    }

    public void newGame() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = null;
            }
        }

        player = 0;
        winner = 0;
        turn = 0;
    }

}


