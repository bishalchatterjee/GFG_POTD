import java.util.Arrays;

public class p48 {
    //Adventure in a Maze
    //Dynamic Programming , Matrix
    //Date- 29/03/2022

    static int count;
    static int[] findWays(int[][] matrix){
        int n=matrix.length;   //get length of the n*n  matrix
        int[][] visited=new int[n][n];  //visited array
        int[][] countArr=new int[n+1][n+1];  //count array
        countArr[n-1][n-1]=1;   //initialize last
        count=0;
        int i=0;
        int j=0;
        int []res=new int[2];

        res[1]=Math.max(0,Helper(matrix,0,0,n,visited,countArr));
        res[0]=countArr[0][0];
        return  res;
    }
    static int Helper(int[][] matrix,int i, int j,int n,int[][] visited,int[][] countArr){
        if(i>=n || j>=n){
            countArr[i][j]=0;
            return Integer.MIN_VALUE;
        }
        if(visited[i][j]==0){
            if(i==n-1 && j==n-1) return matrix[i][j];

            if(matrix[i][j]==1){
                visited[i][j]=1+Helper(matrix,i,j+1,n,visited,countArr);
                countArr[i][j]=countArr[i][j+1];
            }
            else if(matrix[i][j]==2){
                visited[i][j]=2+Helper(matrix,i+1,j,n,visited,countArr);
                countArr[i][j]=countArr[i+1][j];
            }
            else if(matrix[i][j]==3){
                visited[i][j]=3+Math.max(Helper(matrix,i+1,j,n,visited,countArr),Helper(matrix,i,j+1,n,visited,countArr));
                countArr[i][j]=countArr[i][j+1]+countArr[i+1][j]%1000000007;
            }
        }
        return visited[i][j];
    }

    public static void main(String[] args) {
        int matrix[][]={{1,1,3,2,1},
                        {3,2,2,1,2},
                        {1,3,3,1,3},
                        {1,2,3,1,2},
                        {1,1,1,3,1}};

        System.out.println(Arrays.toString(findWays(matrix)));

    }

}


//T.C-O(n^2)
//S.C-O(n^2)