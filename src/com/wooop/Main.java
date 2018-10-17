package com.wooop;
import com.wooop.Soduko;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to 2x2 Soduko!");
        Soduko soduko = new Soduko();
        soduko.generate2d();

        System.out.println("Printing 2x2 Soduko using a 2d array");
        soduko.printBoard2d();

        System.out.println("Printing 2x2 Soduko using a 1d array");
        soduko.generate();
        soduko.printBoard();


        System.out.println("\nGoodbye, hope you had fun!");
    }

}
