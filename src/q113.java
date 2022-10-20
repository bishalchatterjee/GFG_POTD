import java.util.Arrays;

public class q113 {
    //Rat Maze with Multiple Jumps
    //Backtracking
    //02/06/2022

    static int[][] shortestDistance(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] == 0 && col != 1) {
            int ans[][] = {{-1}};
            return ans;
        }
        int ans[][] = new int[row][col];
        if (Helper(matrix, ans, 0, 0) == false) {
            ans[0][0] = -1;
            return ans;
        }
        return ans;
    }

    static boolean isSafe(int x, int y, int matrix[][]) {
        if (x >= matrix.length || y >= matrix[0].length || matrix[x][y] == 0)
            return false;

        return true;
    }

    static boolean Helper(int[][] matrix, int[][] ans, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            ans[i][j] = 1;
            return true;
        }
        if (isSafe(i, j, matrix)) {
            ans[i][j] = 1;
            for (int k = 1; k <= matrix[i][j] && k < matrix.length; k++) {
                if (Helper(matrix, ans, i, j + k)) return true;
                if (Helper(matrix, ans, i + k, j)) return true;
            }
            ans[i][j] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][]={{2,1,0,0},
                {3,0,0,1},
                {0,1,0,1},
                {0,0,0,1}};
        int result[][]=shortestDistance(matrix);

        for (int i = 0; i < result.length ; i++) {
            for (int j = 0; j < result[0].length ; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
