

public class q10 {
    // Find the number of islands.
    // DFS, Graph
    //Date 19/02/2022

    static void dfs(int i, int j, boolean[][] vis, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return;
        if (grid[i][j] == '0') return;
        if (vis[i][j] != true) {
            vis[i][j] = true;
            dfs(i, j + 1, vis, grid);
            dfs(i, j - 1, vis, grid);
            dfs(i + 1, j, vis, grid);
            dfs(i - 1, j, vis, grid);
            dfs(i - 1, j + 1, vis, grid);
            dfs(i + 1, j + 1, vis, grid);
            dfs(i - 1, j - 1, vis, grid);
            dfs(i + 1, j - 1, vis, grid);
        }
    }

    static int numIslands(char[][] grid) {
        // Code here
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (vis[i][j] != true && grid[i][j] == '1') {
                    dfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }
}


//T.C- O(V*E)  //Vertices and Edges

