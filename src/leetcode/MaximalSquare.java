package leetcode;

import util.PrintUtil;

/**
 *
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int down[][] = new int[matrix.length][matrix[0].length];
        int right[][] = new int[matrix.length][matrix[0].length];
        int square[][] = new int[matrix.length][matrix[0].length];
        int max = 0;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                right[i][j] = matrix[i][j] == '0' ? 0 : j == 0 ? 1 : right[i][j - 1] + 1;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                down[i][j] = matrix[i][j] == '0' ? 0 : i == 0 ? 1 : down[i - 1][j] + 1;
            }
        }

//        PrintUtil.printArray(right);
//        System.out.println();
//        PrintUtil.printArray(down);
//        System.out.println();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    square[i][j] = matrix[i][j] - '0';

                } else {
                    square[i][j] = matrix[i][j] == '0' ? 0 :
                            1 + Math.min(Math.min(down[i - 1][j], right[i][j - 1]), square[i - 1][j - 1]);
                }

                if (max < Math.min(i, j) + 1)
                    max = Math.max(max, square[i][j]);

            }
        }
//        PrintUtil.printArray(square);
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]
                {}));
    }
}
