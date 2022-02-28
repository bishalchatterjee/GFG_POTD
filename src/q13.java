import java.util.Arrays;

public class q13 {
    //Spidey Sense
    //DFS, Matrix
    //Date-22/02/2022

    /*
    Approach:
    Step 1 -→

    Replace char matrix with integer matrix.
    Integer.MAX_VALUE for Open Space 0 for Bomb-1 for Wall

    Step 2 -→
    Start DFS on every Bomb Occurred. In DFS Function, minimize depth (d) of every Open Space.

    Step 3 -→

    Replace every Integer.MAX_VALUE with -1 (unreached open spaces).

    Step 4 -→
     Return answer
     */
    static void DFS(int[][] ans, int i, int j, int m, int n, int d) {
        if (i < 0 || i >= m || j < 0 || j >= n || ans[i][j] == 0 || ans[i][j] == -1 || (d > ans[i][j])) return;
        ans[i][j] = d;
        int[][] dxy = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dd : dxy) {
            DFS(ans, i + dd[0], j + dd[1], m, n, d + 1);
        }
    }

    static int[][] findDistance(char mat[][], int n, int m) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (mat[i][j]) {
                    case 'O':
                        ans[i][j] = Integer.MAX_VALUE;
                        break;
                    case 'B':
                        ans[i][j] = 0;
                        break;
                    case 'W':
                        ans[i][j] = -1;
                        break;
                }
            }
        }

        //DFS when we see a Bomb
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) {
                    DFS(ans, i + 1, j, m, n, 1);
                    DFS(ans, i, j + 1, m, n, 1);
                    DFS(ans, i, j - 1, m, n, 1);
                    DFS(ans, i - 1, j, m, n, 1);
                }
            }
        }

        //Replace unreached Open Spaces with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == Integer.MAX_VALUE) {
                    ans[i][j] = -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        char[][] A = {{'O', 'O', 'O'},
                      {'W', 'B', 'B'},
                      {'W', 'O', 'O'}};
        int final_sol[][] = findDistance(A, n, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(final_sol[i][j]+" ");
            }
            System.out.println();
        }
    }
}

//T.C -O(M*N)+O(M+N)


/*
Using Queue & BFS

class Solution
{

    private static final int [][] direction = new int [][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int[][] findDistance(char mat[][], int m,int n)
    {
        // Your code goes here
        if (mat == null || m == 0) {
            return new int [][]{};
        }
        int [][] result = new int [m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(result[i], Integer.MAX_VALUE);
        bfs(mat, m, n, result);
        return result;
    }

    public static void bfs(char [][] mat, int m, int n, int [][] result) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'B') {
                    queue.offer(new int []{i, j});
                    result[i][j] = 0;
                }
            }
        }
        if (queue.isEmpty()) {
            for (int i = 0; i < m; i++)
                Arrays.fill(result[i], -1);
            return;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] current = queue.poll();
                mat[current[0]][current[1]] = 'P';
                for (int [] dir : direction) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || mat[x][y] != 'O') {
                        continue;
                    }
                    result[x][y] = Math.min(result[x][y], result[current[0]][current[1]] + 1);
                    queue.offer(new int []{x, y});
                }
            }
        }
        extraWorkForResult(result, m, n);
    }

    public static void extraWorkForResult(int [][] result, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == Integer.MAX_VALUE) {
                    result[i][j] = -1;
                }
            }
        }
    }
}
 */