package com.wooop;
import java.util.Random;


public class Soduko {

    int board [];
    int board2d [][];
    Random rand;

    public Soduko() {
        rand = new Random();
    }

    public void generate() {
        board = new int[16];
        int i = 0;
        int deadlock = 0;
        while (i < 16) {
            boolean rowClear;
            boolean columnClear;
            boolean quadrantClear;
            int nextNumber = rand.nextInt(4) + 1;

            rowClear = (nextNumber != board[((i+1)%4)+(4*(i/4))] && nextNumber != board[((i+2)%4)+(4*(i/4))] && nextNumber != board[((i+3)%4)+(4*(i/4))]);

            columnClear = (nextNumber != board[(i+4)%16] && nextNumber != board[(i+8)%16] && nextNumber != board[(i+12)%16]);

            if(i>3) {
                quadrantClear = (nextNumber != board[((i % 4) + ((((i + 1) % 2) * 2) - 1)) + (4 * ((i / 4) - 1))]);
            } else {
                quadrantClear = true;
            }

            if(rowClear && columnClear && quadrantClear) {
                board[i] = nextNumber;
                i++;
            }

            //deadlock stopper
            deadlock++;
            if(deadlock > 100) {
                board = new int[16];
                i = 0;
                deadlock = 0;
            }
        }
    }

    public void generate2d() {
        board2d = new int[4][4];
        int deadlock = 0;

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                boolean rowClear;
                boolean columnClear;
                boolean quadrantClear;
                int nextNumber = rand.nextInt(4) + 1;

                //Check next 3 in row, loop around using modulus if out of bounds
                rowClear = (nextNumber != board2d[(x+1)%4][y] && nextNumber != board2d[(x+2)%4][y] && nextNumber != board2d[(x+3)%4][y]);

                //Check next 3 in column, loop around using modulus if out of bounds
                columnClear = (nextNumber != board2d[x][(y+1)%4] && nextNumber != board2d[x][(y+2)%4] && nextNumber != board2d[x][(y+3)%4]);

                if(x > 0) { //skip first row
                    // Check diagonally backwards on second and fourth row
                    quadrantClear = (nextNumber != board2d[x+((((x+1)%2)*2)-1)][2*((y/2))]);
                } else {
                    quadrantClear = true;
                }

                if(rowClear && columnClear && quadrantClear){
                    board2d[x][y] = nextNumber;
                } else {
                    x--;
                }

                //deadlock stopper
                deadlock++;
                if(deadlock > 100) {
                    board2d = new int[4][4];
                    x = -1;
                    y = 0;
                    deadlock = 0;
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 16; i++) {
            System.out.print("|");
            System.out.print(board[i]);
            if(i%4==3){
                System.out.print("|");
                System.out.println();
            }
        }
    }

    public void printBoard2d() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print("|");
                System.out.print(board2d[x][y]);
            }
            System.out.println("|");
        }
        System.out.println();
    }
}
