package leetcode;

/**
 *
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean l2r = true;
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
//            System.out.println(i + " " + index+" "+matrix[i][index]);
            l2r = matrix[i][index] <= target;
            if (l2r)
                while (index < matrix[0].length) {
//                    System.out.println(i + " " + index+"  "+matrix[i][index]);
                    if (matrix[i][index] == target)
                        return true;
                    else if (matrix[i][index] < target)
                        index++;
                    else {

                        break;
                    }

                }
            else
                while (index >= 0) {
//                    System.out.println(i + " " + index + "   " + matrix[i][index]);
                    if (matrix[i][index] == target)
                        return true;
                    else if (matrix[i][index] > target)
                        index--;
                    else {

                        break;
                    }

                }
            if (index == matrix[0].length)
                index = matrix[0].length - 1;
            if (index == -1)
                index = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Searcha2DMatrixII().searchMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}}, 19));
    }
}
