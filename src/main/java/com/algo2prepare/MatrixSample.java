package com.algo2prepare;

import com.algo2prepare.util.Matrix;

public class MatrixSample {

    public static void main(String[] args) {

        int[][] a1 = Matrix.randomInts(3);                                 // 3x3 matrix with random ints
        int[][] a2 = Matrix.randomInts(3, 2);                      // 3x2 (3 rows, 2 cols_ with random ints
        int[][] a3 = Matrix.randomInts(3, 0, 10);             // 3x3 matrix with random ints in range [0,10]
        int[][] a4 = Matrix.randomInts(3, 4, 0, 10);  // 3x4 matrix with random ints in range [0,10]

        int[][] b1 =  Matrix.ints("[[1,2,3],[4,5,6],[7,8,9]]");       // 3x3 matrix of ints
        char[][] b2 = Matrix.chars("[[g,h,j],[a,b,c]]");              // 3x2 matrix of chars
        String[][] b3 = Matrix.strings("[[\"a\",\"b\",\"c\"],[\"d\",\"e\",\"f\"],[\"g\",\"e\",\"h\"]]");

        Matrix.print(a1);
        Matrix.print(a2);
        Matrix.print(a3);


    }

}
