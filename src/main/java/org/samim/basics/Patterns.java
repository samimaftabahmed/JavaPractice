package org.samim.basics;

import java.security.SecureRandom;

public class Patterns {

    private static final String STAR = "* ";

    public static void main(String[] args) {
        boolean printStars = new SecureRandom().nextBoolean();

        halfPyramid(printStars);
        System.out.println();

        hollowRectangle(printStars);
        System.out.println();

        invertedPyramid(printStars);
        System.out.println();

        halfPyramidWithEmptySpacesInFront(printStars);
        System.out.println();

        floydTriangle();
        System.out.println();

        zeroOneTriangle();
        System.out.println();
    }

    /*
      Pattern: Half Pyramid
        1
        2 2
        3 3 3
        4 4 4 4
        *
        * *
        * * *
        * * * *
     */
    private static void halfPyramid(boolean printStars) {
        System.out.println("Half Pyramid");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                String printText = printStars ? STAR : i + " ";
                System.out.print(printText);
            }
            System.out.print("\n");
        }
    }

    /*
      Pattern: Hollow Rectangle
      * * * * *
      *       *
      *       *
      * * * * *
     */
    private static void hollowRectangle(boolean printStars) {
        System.out.println("Hollow Rectangle");
        int length = 5;
        int breadth = 8;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= breadth; j++) {
                boolean firstAndLastCondition = (i == 1 || i == length);
                boolean hollowCondition = (j == 1 || j == breadth);
                String printStarOrNum = printStars ?
                        STAR : j + " ";
                String printText = firstAndLastCondition || hollowCondition ?
                        printStarOrNum : "  ";
                System.out.print(printText);
            }
            System.out.print("\n");
        }
    }

    /*
      Pattern: Inverted Half Pyramid
        * * * *
        * * *
        * *
        *
     */
    private static void invertedPyramid(boolean printStars) {
        System.out.println("Inverted Pyramid");
        int max = 6;
        for (int i = 0; i < max; i++) {
            for (int j = (max - i); j > 0; j--) {
                String printText = printStars ? STAR : (i + 1) + " ";
                System.out.print(printText);
            }
            System.out.print("\n");
        }
    }

    /*
        Pattern: Half Pyramid With Empty Spaces
              *
            * *
          * * *
        * * * *
     */
    private static void halfPyramidWithEmptySpacesInFront(boolean printStars) {
        System.out.println("Half Pyramid With Empty Spaces In Front");
        int max = 5;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                String printText = printStars ? STAR : k + " ";
                System.out.print(printText);
            }
            System.out.print("\n");
        }
    }

    /*
        Floyd's Triangle
        1
        2 3
        4 5 6
        7 8 9 10
     */
    private static void floydTriangle() {
        System.out.println("Floyd's Triangle");
        int max = 4;
        int floydNum = 1;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(floydNum + " ");
                floydNum++;
            }
            System.out.println();
        }
    }

    /*
        0-1 Triangle
        1
        0 1
        1 0 1
        0 1 0 1
        1 0 1 0 1
     */
    private static void zeroOneTriangle() {
        System.out.println("0-1 Triangle");
        int max = 5;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= i; j++) {
                int sum = i + j;
                int printText = sum % 2 == 0 ? 1 : 0;
                System.out.print(printText + " ");
            }
            System.out.println();
        }
    }
}
