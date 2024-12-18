package org.samim.basics;

public class AdvancePatterns {

    public static void main(String[] args) {
        butterfly();
        hollowButterfly();
        rhombus();
        hollowRhombus();
        numberPyramid();
        palindromeTriangle();
        pascalsTriangle();
        diamond();
    }

    /*
        Butterfly
        *             *
        * *         * *
        * * *     * * *
        * * * * * * * *
        * * * * * * * *
        * * *     * * *
        * *         * *
        *             *
     */
    private static void butterfly() {
        System.out.println("Butterfly");
        int max = 5;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            int limit = 2 * (max - i);
            for (int k = limit; k > 0; k--) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = max; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            int limit = 2 * (max - i);
            for (int k = limit; k > 0; k--) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
    Hollow Butterfly
        *                         *
        * *                     * *
        *   *                 *   *
        *     *             *     *
        *       *         *       *
        *         *     *         *
        *           * *           *
        *           * *           *
        *         *     *         *
        *       *         *       *
        *     *             *     *
        *   *                 *   *
        * *                     * *
        *                         *
     */
    private static void hollowButterfly() {
        System.out.println("\nHollow Butterfly");
        int max = 7;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= i; j++) {
                String printText = j == 1 || j == i ? "* " : "  ";
                System.out.print(printText);
            }

            for (int j = (max * 2 - i * 2); j >= 1; j--) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                String printText = j == 1 || j == i ? "* " : "  ";
                System.out.print(printText);
            }
            System.out.println();
        }

        for (int i = max; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                String printText = j == 1 || j == i ? "* " : "  ";
                System.out.print(printText);
            }

            for (int j = (max * 2 - i * 2); j >= 1; j--) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                String printText = j == 1 || j == i ? "* " : "  ";
                System.out.print(printText);
            }
            System.out.println();
        }
    }

    /*
        Rhombus
                  * * * * * *
                * * * * * *
              * * * * * *
            * * * * * *
          * * * * * *
        * * * * * *
     */
    private static void rhombus() {
        System.out.println("\nRhombus");
        int max = 5;
        for (int i = 1; i <= max; i++) {
            int spaces = max - i;
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= max; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    /*
        Hollow Rhombus
                * * * * *
              *       *
            *       *
          *       *
        * * * * *
     */
    private static void hollowRhombus() {
        System.out.println("\nHollow Rhombus");
        int max = 5;
        for (int i = 1; i <= max; i++) {
            for (int j = max - i; j > 0; j--) {
                System.out.print("   ");
            }

            for (int k = 1; k <= max; k++) {
                boolean leftRight = (i == 1 || i == max);
                boolean topBottom = (k == 1 || k == max);
                if (topBottom || leftRight) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    /*
          Number Pyramid
                1
               2 2
              3 3 3
             4 4 4 4
            5 5 5 5 5
           6 6 6 6 6 6
          7 7 7 7 7 7 7
         8 8 8 8 8 8 8 8
        9 9 9 9 9 9 9 9 9
     */
    private static void numberPyramid() {
        System.out.println("\nNumber Pyramid");
        int max = 6;
        for (int i = 1; i <= max; i++) {
            int spaces = max - i;
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void pascalsTriangle() {
        System.out.println("\nPascal Triangle / Pyramid\n");
        int max = 6;
        for (int i = 0; i < max; i++) {
//            int spaces = max - i;
//            for (int j = 0; j < spaces; j++) {
//                System.out.print(" ");
//            }

            int number = 1;
            for (int j = 0; j <= i; j++) {
                int num = (i - j);
                int den = (j + 1);
//                System.out.println(number + " ");
                double ratio = (double) num / den;
                String numPrint = String.format("num: (i - j) = (%d - %d) = %d", i, j, num);
                String denPrint = String.format("num: (j + 1) = (%d + 1) = %d", j, den);
                String ratioPrint = String.format("num/den = %d/%d = %f", num, den, ratio);

                System.out.println(numPrint);
                System.out.println(denPrint);
                System.out.println(ratioPrint);

                System.out.println("Before number= " + number);
                number = (int) (number * ratio);
                String format = String.format("After number = (number * ratio) = (%d * %f) = %d", number, ratio, number);
                System.out.println(format);
                System.out.println();

            }
            System.out.println("%n--- i=%s Ends ---%n".formatted(i));
        }
    }

    /*
        Palindrome Triangle
                  1
                2 1 2
              3 2 1 2 3
            4 3 2 1 2 3 4
          5 4 3 2 1 2 3 4 5
        6 5 4 3 2 1 2 3 4 5 6
     */
    private static void palindromeTriangle() {
        System.out.println("\nPalindrome Triangle");
        int max = 6;
        for (int i = 1; i <= max; i++) {
            // print white spaces
            for (int j = 1; j <= (max - i); j++) {
                System.out.print(" ");
            }

            // print palindrome numbers
            boolean decrement = true;
            int value = i;
            for (int j = 1; j <= (i * 2 - 1); j++) {
                System.out.print(value);
                value = decrement ? value - 1 : value + 1;
                if (value == 1) {
                    decrement = false;
                }
            }
            System.out.println();
        }
    }

    /*
        Diamond
              *
            * * *
          * * * * *
        * * * * * * *
          * * * * *
            * * *
              *
     */
    private static void diamond() {
        System.out.println("\nDiamond");
        int max = 4;
        for (int i = 1; i <= max; i++) {
            // print spaces
            for (int j = (max - i); j > 0; j--) {
                System.out.print("  ");
            }
            // print stars
            for (int j = 1; j <= (i * 2 - 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        for (int i = max - 1; i > 0; i--) {
            // print spaces
            for (int j = (max - i); j > 0; j--) {
                System.out.print("  ");
            }
            // print stars
            for (int j = 1; j <= (i * 2 - 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
