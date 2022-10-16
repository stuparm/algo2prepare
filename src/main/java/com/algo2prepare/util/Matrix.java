package com.algo2prepare.util;

import java.util.Random;

/**
 * @author Mihailo Stupar
 */
public class Matrix {

    /**
     * Converts text that describes matrix to int[][]
     * @param text "[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"
     * @return int[][] -> [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
     */
    public static int[][] ints(String text) {
        String[] lines = text.split("],\\[");
        int[][] matrix = new int[lines.length][];
        for (int row = 0; row < lines.length; row++) {
            String line = lines[row];
            line = line.replaceAll("\\[","").replaceAll("]","")
                       .replaceAll("\"","").replaceAll("'","");
            String[] vals = line.split(",");
            int[] ints = new int[vals.length];
            for (int i = 0; i < vals.length; i++) {
                ints[i] = Integer.parseInt(vals[i]);
            }
            matrix[row] = ints;
        }
        return matrix;
    }

    /**
     * Converts text that describes matrix to String[][]
     * @param text "[["a","b","c"],["d","e","f"],["g","e","h"]]" or "[[a,b,c],[d,e,f],[g,h,i]]"
     * @return String[][] -> [["a","b","c"],["d","e","f"],["g","e","h"]]
     */
    public static String[][] strings(String text) {
        String[] lines = text.split("],\\[");
        String[][] matrix = new String[lines.length][];
        for (int row = 0; row < lines.length; row++) {
            String line = lines[row];
            line = line.replaceAll("\\[","").replaceAll("]","");
            String[] vals = line.split(",");
            String[] strings = new String[vals.length];
            for (int i = 0; i < vals.length; i++) {
                strings[i] = vals[i].replaceAll("\"","");
            }
            matrix[row] = strings;
        }
        return matrix;
    }

    /**
     * Converts text that describes matrix to char[][]
     * @param text example "[["a","b","c"],["d","e","f"],["g","e","h"]]" or "[[a,b,c],[d,e,f],[g,h,i]]" or
     *             "[['a','b','c'],['d','e','f'],['g','h','i']]"
     * @return char[][] -> [['a','b','c'],['d','e','f'],['g','h','i']]
     */
    public static char[][] chars(String text) {
        String[] lines = text.split("],\\[");
        char[][] matrix = new char[lines.length][];
        for (int row = 0; row < lines.length; row++) {
            String line = lines[row];
            line = line.replaceAll("\\[","").replaceAll("]","")
                       .replaceAll("\"","").replaceAll("'","");
            String[] vals = line.split(",");
            char[] chars = new char[vals.length];
            for (int i = 0; i < vals.length; i++) {
                chars[i] = vals[i].charAt(0);
            }
            matrix[row] = chars;
        }
        return matrix;
    }

    /**
     * Generates nxn matrix with random integers
     * @param n size of the matrix, number of rows and columns
     */
    public static int[][] randomInts(int n) {
        int[][] matrix = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Generates [rows x cols] matrix with random integers
     * @param rows number of rows in matrix
     * @param cols number of columns in matrix
     */
    public static int[][] randomInts(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = r.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Generates [rows x cols] matrix with random integers
     * @param rows number of rows in matrix
     * @param cols number of columns in matrix
     * @param lower lower bound for int generator (included)
     * @param upper upper bound for int generator (included)
     */
    public static int[][] randomInts(int rows, int cols, int lower, int upper) {
        int[][] matrix = new int[rows][cols];
        Random r = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int bound = upper-lower+1;
                matrix[i][j] = r.nextInt(bound)+lower;
            }
        }
        return matrix;
    }

    /**
     * Generates nxn matrix with random integers
     * @param n number of rows and number of columns are equal (size)
     * @param lower lower bound for int generator (included)
     * @param upper upper bound for int generator (included)
     */
    public static int[][] randomInts(int n, int lower, int upper) {
        int[][] matrix = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int bound = upper-lower+1;
                matrix[i][j] = r.nextInt(bound)+lower;
            }
        }
        return matrix;
    }



    //print methods
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }






}
