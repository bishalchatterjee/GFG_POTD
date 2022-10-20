public class q177 {
    //
    //
    //

    static int xShapeFinder(char[][] grid){
        int res=0;
        int row= grid.length;
        int col= grid[0].length;

        boolean[][] visited=new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                if(grid[i][j]=='X' && !visited[i][j]){
                    res++;
                    helperDFS(grid,i,j,visited);
                }
            }
        }
        return res;
    }
    static void helperDFS(char[][] grid,int i,int j,boolean visited[][]){
        if(grid[i][j]=='X') return;
        if(visited[i][j]) return;

        visited[i][j]=true;

        if(i>0) helperDFS(grid,i-1,j,visited);
        if(i< grid.length-1) helperDFS(grid,i+1,j,visited);
        if(j>0) helperDFS(grid,i,j-1,visited);
        if(j< grid[0].length) helperDFS(grid,i,j+1,visited);
    }

    public static void main(String[] args) {
        char[][] grid={{'X','O','X'},
                {'O','X','O'},
                {'X','X','X'}};

        System.out.println(xShapeFinder(grid));
    }
}
