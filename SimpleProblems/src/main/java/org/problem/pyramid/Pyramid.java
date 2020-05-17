package org.problem.pyramid;

/**
 * Created by shantonu on 11/21/16.
 */
public class Pyramid {

    public static void main(String args[]) {
        pyramidTypeThree();
    }

    public static void pyramidTypeOne() {

        System.out.println("This is pyramid problem 1 ");

        for (int row = 1; row <= 4; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void pyramidTypeTwo() {

        System.out.println("This is pyramid problem 2 ");

        for (int row = 1; row <= 5; row++) {
            for (int space = 1; space <= (5 - row); space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void pyramidTypeThree() {
        System.out.println("This is pyramid problem 3");
        for (int row = 1; row <= 5; row++) {
            for (int space = 1; space <= (5 - row); space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}