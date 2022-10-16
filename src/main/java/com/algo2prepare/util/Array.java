package com.algo2prepare.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Mihailo Stupar
 */
public class Array {



    public static int[] ints(int... ints) {
        return ints;
    }

    public static double[] doubles(double... doubles) {
        return doubles;
    }

    public static String[] strings(String... strings) {
        return strings;
    }

    public static char[] chars(char... chars) { return chars; }

    /**
     * Converts integers to chars. Note that int values can be in range [0-9]
     * @param ints example: [1, 2, 3]
     * @return ['1', '2', '3']
     */
    public static char[] chars(int... ints) {
        int N = ints.length;
        char[] chars = new char[N];
        for (int i = 0; i < N; i++) {
            chars[i] = Character.forDigit(ints[i], 10);
        }
        return chars;
    }

    /**
     * Converts integers to strings.
     * @param ints example: [1, 2, 3]
     * @return ["1", "2", "3"]
     */
    public static String[] strings(int... ints) {
        int N = ints.length;
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = String.valueOf(ints[i]);
        }
        return strings;
    }

    /**
     * converts text representation of array to int[] array
     * @param text example: "[1,2,3]"
     * @return [1, 2, 3]
     */
    public static int[] ints(String text) {
        String tmp = text.replaceAll("\\[","").replaceAll("]","");
        String[] vals = tmp.split(",");
        int[] ints = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            ints[i] = Integer.parseInt(vals[i].replaceAll("'","").replaceAll("\"",""));
        }
        return ints;
    }

    /**
     * converts text representation of array to String[] array
     * @param text example: "["1","2","3"]"
     * @return ["1","2","3"]
     */
    public static String[] strings(String text) {
        String tmp = text.replaceAll("\\[","").replaceAll("]","");
        String[] vals = tmp.split(",");
        String[] strings = new String[vals.length];
        for (int i = 0; i < vals.length; i++) {
            strings[i] = vals[i].replaceAll("\"","").replaceAll("'","");
        }
        return strings;
    }

    /**
     * converts text representation of array to char[] array
     * @param text example: "['1','2','3']"
     * @return ['1','2','3']
     */
    public static char[] chars(String text) {
        String tmp = text.replaceAll("\\[","").replaceAll("]","");
        String[] vals = tmp.split(",");
        char[] chars = new char[vals.length];
        for (int i = 0; i < vals.length; i++) {
            chars[i] = vals[i].replaceAll("'","").replaceAll("\"","").charAt(0);
        }
        return chars;
    }

    /**
     * converts text representation of array to double[] array
     * @param text example: "[1.0, 2.0, 3.0]"
     * @return [1.0, 2.0, 3.0]
     */
    public static double[] doubles(String text) {
        String tmp = text.replaceAll("\\[","").replaceAll("]","");
        String[] vals = tmp.split(",");
        double[] doubles = new double[vals.length];
        for (int i = 0; i < vals.length; i++) {
            doubles[i] = Double.valueOf(vals[i].replaceAll("\"","").replaceAll("'",""));
        }
        return doubles;
    }

    /**
     * Generates array with random integers
     * @param n length of array
     */
    public static int[] randomInts(int n) {
        Random r = new Random();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = r.nextInt();
        }
        return ints;
    }

    /**
     * Generates array with random integers where values are between [lower] and [upper] bound
     * @param n length of the array
     * @param lower lower bound for int generator (included)
     * @param upper upper bound for int generator (included)
     */
    public static int[] randomInts(int n, int lower, int upper) {
        Random r = new Random();
        int[] ints = new int[n];
        int bound = upper-lower+1;
        for (int i = 0; i < n; i++) {
            ints[i] = r.nextInt(bound)+lower;
        }
        return ints;
    }

    /**
     * Generates array with random integers where values are between [lower] and [upper] bound. Values in array are
     * {@link NumberType#EVEN} or {@link NumberType#ODD}
     * @param n length of the array
     * @param lower lower bound for int generator (included)
     * @param upper upper bound for int generator (included)
     * @param numberType ODD or EVEN elements in array
     */
    public static int[] randomInts(int n, int lower, int upper, NumberType numberType) {
        Random r = new Random();
        int[] ints = new int[n];
        int bound = upper-lower+1;
        for (int i = 0; i < n; i++) {
            if(numberType == NumberType.ODD) {
                int val = r.nextInt(bound)+lower;
                while (val % 2 != 1) {
                    val = r.nextInt(bound)+lower;
                }
                ints[i] = val;
            } else { //numberType == EVEN
                int val = r.nextInt(bound)+lower;
                while (val % 2 != 0) {
                    val = r.nextInt(bound)+lower;
                }
                ints[i] = val;
            }
        }
        return ints;
    }


    /**
     * Generates array with random integers where values are between [lower] and [upper] bound. Array will be sorted
     * either {@link Order#ASC} or {@link Order#DESC}
     * @param n length of array
     * @param lower lower bound for int generator (included)
     * @param upper upper bound for int generator (included)
     * @param order ASC or DESC order in returned array
     */
    public static int[] randomInts(int n, int lower, int upper, Order order) {
        int[] arr = randomInts(n, lower, upper);
        Arrays.sort(arr);
        if (order == Order.ASC) {
            return arr;
        }
        if (order == Order.DESC) {
            for (int i = 0; i < arr.length/2; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = tmp;
            }
            return arr;
        }
        System.out.println("Not a valid order");
        return null;

    }


    // printing methods
    public static void print(String[] arr) {
        String result = String.join(", ", arr);
        System.out.println(result);
    }

    public static void print(int[] arr) {
        String result = Arrays.toString(arr).replace("[", "").replace("]", "");
        System.out.println(result);
    }

    public static void print(double[] arr) {
        String result = Arrays.toString(arr).replace("[", "").replace("]", "");
        System.out.println(result);
    }

    public static void print(char[] arr) {
        String result = Arrays.toString(arr).replace("[", "").replace("]", "");
        System.out.println(result);
    }


}
