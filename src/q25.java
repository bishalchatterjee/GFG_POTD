import java.util.Arrays;

public class q25 {
    //Compute Before Matrix from an After Matrix
    //Matrix , Prefix-Sum
    //Date-06/03/2022

   static int[][] computeBeforeMatrix(int N, int M, int[][] after){
        // Code here
        // The number formed if it is on the edge will be the initial currNo + the initial prevNo
        // Otherwise it will be currNo - the top and left no and add the diagonal no to the top left
        // a b
        // c d
        // new a = a, new b = a + b, new c = a + c, new d = a + b + c + d
        // a = new a, b = new b - a, c = new c - a, d = new d - new b - new c + new a
        int[][] prev = new int[after.length][after[0].length];
        for(int i = 0 ; i < after.length; i++){
            for(int j = 0; j < after[0].length; j++){
                if(i == 0 && j == 0) prev[i][j] =  after[0][0];
                else if(i == 0 && j > 0) prev[i][j] = after[i][j] - after[i][j-1];
                else if(i > 0 && j == 0) prev[i][j] = after[i][j] - after[i-1][j];
                else prev[i][j] = after[i][j] - after[i][j-1] - after[i-1][j] + after[i-1][j-1];
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        int after[][] = {{1, 3, 6},
                        {3, 7, 11}};
        int N=after.length;
        int M=after[0].length;
        int res[][]=computeBeforeMatrix(N,M,after);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}


//T.C-O(M*N)
//S.C-O(1)