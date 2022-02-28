import java.util.Arrays;

public class q12 {
    //Optimal Binary Search Tree
    //Dynamic Programming( Variation of --> Matrix chain multiplication and Catalan number Concepts
    //Date 21/02/2022

    static int dp[][][]=new int[100][100][100]; // As per question Constrain

    static int optimalSearchTree(int key[],int freq[],int n){

        //initialize the dp[][][] with -1
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return optimalSearchTreeHelper(0,n-1,freq,1);
    }
    static int optimalSearchTreeHelper(int i,int j, int freq[],int level){
        if(i > j) return 0;
        if(i==j) return level*freq[i];
        if(dp[i][j][level]!=-1) return dp[i][j][level];

        int ans=Integer.MAX_VALUE;
        for (int k = 0; k <=j ; k++) {
            int leftChild=optimalSearchTreeHelper(i,k-1,freq,level+1);
            int rightChild=optimalSearchTreeHelper(k+1,j,freq,level+1);
            int parent=(freq[k]*level)+leftChild+rightChild;
            ans=Math.min(ans,parent);
        }
        return dp[i][j][level]=ans;
    }

    public static void main(String[] args) {
        int n=2;
        int keys[]={10,12};
        int freq[]={34,50};

        System.out.println(optimalSearchTree(keys,freq,n));
    }
}

//T.C-O(n^3)
