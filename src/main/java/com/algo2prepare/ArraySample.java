package com.algo2prepare;

import com.algo2prepare.util.Array;
import com.algo2prepare.util.NumberType;
import com.algo2prepare.util.Order;

public class ArraySample {

    public static void main(String[] args) {

        int[] a1 =    Array.ints(1,2,3,4);            // [1, 2, 3, 4]
        char[] a2 =   Array.chars(1,2,3,4);     // ['1', '2', '3', '4']
        String[] a3 = Array.strings("A","B","C");     // ["A", "B", "C"]
        double[] a4 = Array.doubles(1,2,3.0);         // [1.0, 2.0, 3.0]

        int[] b1 = Array.randomInts(4);                                     // [-1637497961, -905139890, -311524229, -479298768]
        int[] b2 = Array.randomInts(5, 0, 10);                 // [4, 9, 0, 3, 10]
        int[] b3 = Array.randomInts(3,0,10, Order.ASC);        // [4, 6, 10]
        int[] b4 = Array.randomInts(3,0,10, NumberType.EVEN);  // [6, 2, 8]

        int[] c1 =    Array.ints("[1,2,3,4]");                // [1, 2, 3, 4]
        char[] c2 =   Array.chars("['s','a','n','n']");       // ['s', 'a', 'n', 'n']
        String[] c3 = Array.strings("[\"qwe\",\"rty\"]");     // ["qwe", "rty"]
        double[] c4 = Array.doubles("[3.2, 5.5]");            // [3.2 5.5]

        Array.print(c1);
        Array.print(c2);
        Array.print(c3);
        Array.print(c4);

    }

}
