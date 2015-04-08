package leetcode;

/**
 *
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length==0)
            return count;

        boolean[][] arrive = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!arrive[i][j] && grid[i][j] == '1') {
                    count++;
                    go(grid, arrive, i, j);
                }
            }
        }

        return count;

    }

    private void go(char[][] grid, boolean[][] arrive, int i, int j) {
        if (i > 0 && !arrive[i - 1][j] && grid[i - 1][j] == '1') {
            arrive[i - 1][j] = true;
            go(grid, arrive, i - 1, j);
        }

        if (j > 0 && !arrive[i][j - 1] && grid[i][j - 1] == '1') {
            arrive[i][j - 1] = true;
            go(grid, arrive, i, j - 1);
        }

        if (i < grid.length - 1 && !arrive[i + 1][j] && grid[i + 1][j] == '1') {
            arrive[i + 1][j] = true;
            go(grid, arrive, i + 1, j);
        }

        if (j < grid[i].length - 1 && !arrive[i][j + 1] && grid[i][j + 1] == '1') {
            arrive[i][j + 1] = true;
            go(grid, arrive, i, j + 1);
        }
    }


    /**
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new NumberofIslands().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));
    }
}
