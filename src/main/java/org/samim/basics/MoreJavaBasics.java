package org.samim.basics;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class MoreJavaBasics {

    private static int count = 1;

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        infiniteLoops();
        series_Fibonacci();
        greatestCommonFactor_1(15000000, 6000000);
        greatestCommonFactor_2(15000000, 6000000);

        arrayElementsNoInitialization();
        arrayStringCumulativeLength();
        stringCompareTo();
        stringBuilderOperations();
        reverseString();
    }

    private static void arrayStringCumulativeLength() throws NoSuchAlgorithmException {
        System.out.println("\nArray Elements cumulative length");
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        int totalLength = 0;
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = secureRandom.nextInt(20, 99);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String s = "" + matrix[i][j];
                totalLength += s.length();
                System.out.print(s + "  ");
            }
            System.out.println();
        }

        System.out.println("Total Length: " + totalLength);
    }

    private static void stringCompareTo() {
        System.out.println("\nString compareTo()");
        String a = "hello";
        String b = "mellow";
        String c = "wellow";

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));
        System.out.println(a.compareTo(c));
    }

    private static void stringBuilderOperations() {
        System.out.println("\nStringBuilder OPerations");
        StringBuilder sb = new StringBuilder("Tony");
        sb.append(" Stark");
        System.out.println(sb);

        sb.insert(5, "Kumar ");
        System.out.println(sb);

        sb.insert(0, "S");
        System.out.println(sb);

        sb.delete(0, 1);
        System.out.println(sb);

        sb.delete(5, 11);
        System.out.println(sb);

        System.out.println(sb.reverse());
    }

    private static void reverseString() {
        System.out.println("\nReverse of a String with front and back variables.");
        StringBuilder sss = new StringBuilder("abcde");
        for (int i = 0, limit = (sss.length() / 2); i < limit; i++) {
            int j = sss.length() - 1 - i;
            char front = sss.charAt(i);
            char back = sss.charAt(j);

            sss.setCharAt(i, back);
            sss.setCharAt(j, front);
        }

        System.out.println(sss);
    }

    private static void infiniteLoops() {
//        do {
//            System.out.println("Infinite Do-While Loop");
//        } while (true);
//
//        while (true){
//            System.out.println("Infinite While Loop");
//        }

//        for (int i = 0; true; i++) {
//            System.out.println("Infinite for loop");
//        }

        // Not possible: ConcurrentModificationException
        /*
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        for (Integer i : integers) {
            System.out.println(i);
            integers.add(2);
        }
        */

    }

    private static void series_Fibonacci() {
        System.out.println("Fibonacci");
        int sum = 0;
        int nextNum = 1;
        int newSum = 0;
        int max = 20;

        for (int i = 0; i < max; i++) {
            sum = newSum;
            newSum = sum + nextNum;
            nextNum = sum;
//            String format = String.format("sum=%d, newSum=%d , nextNum=%d", sum, newSum, nextNum);
            System.out.print("  " + newSum);
//            System.out.println(format);
        }
    }

    private static void greatestCommonFactor_1(int inputA, int inputB) {
        System.out.println("\n\nGreatest Common Factor");
        if (inputB == 0 || inputA == 0) {
            System.out.println("GCF: 0");
            return;
        }
        int max = inputA > inputB ? inputA : inputB;
        int gcf = 1;
        int iterations = 1;

        for (; iterations < max; iterations++) {
            int resultA = inputA % iterations;
            int resultB = inputB % iterations;
            if (resultA == 0 && resultB == 0) {
                gcf = iterations;
            }
        }
        System.out.println("iterations: " + iterations);
        System.out.println("GCF: " + gcf);
    }

    private static void greatestCommonFactor_2(int inputA, int inputB) {
        System.out.println("\nGreatest Common Factor - Optimized");
        if (inputB == 0 || inputA == 0) {
            System.out.println("GCF: 0");
            return;
        }

        int gcf = calculateGCF(inputA, inputB);
        System.out.println("Recursions: " + count);
        System.out.println("GCF: " + gcf);
    }

    private static int calculateGCF(int inputA, int inputB) {
//        System.out.printf("inputA: %s, inputB: %s%n", inputA, inputB);
        int remainder = inputA % inputB;
        if (remainder == 0) {
            return inputB;
        } else {
            count++;
            return calculateGCF(inputB, remainder);
        }
    }

    private static void arrayElementsNoInitialization() {
        System.out.println("\nArray elements without initialization");
        System.out.println("output: ");
        System.out.println("boolean: " + Arrays.toString(new boolean[3])); // all false when not initialized
        System.out.println("double: " + Arrays.toString(new double[3])); // all 0.0 when not initialized
        System.out.println("float: " + Arrays.toString(new float[3])); // all 0.0 when not initialized
        System.out.println("int: " + Arrays.toString(new int[3])); // all 0 when not initialized
        System.out.println("String: " + Arrays.toString(new String[3])); // all null when not initialized

        int position = Arrays.binarySearch(new int[]{3, 1, 4, 6}, 4);
        System.out.println("Binary Search :: position: " + position);
        System.out.println("Samim".substring(0, 3)); // Sam
    }

}
