import java.util.Arrays;

public class q17 {
//Escape The Forbidden Forest
    //Strings ,LCS, DP
    //Date-26/02/2022

    static int build_bridges(String str1,String str2){
        int m=str1.length(); //length of first string
        int n=str2.length(); // length of second string

        int dp[][]=new int[m+1][n+1]; //declaring Dp Array
        for (int row[]:dp) //filling dp 2D-array with 0
            Arrays.fill(row,0);

        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))  //if characters match
                    dp[i][j]=dp[i-1][j-1]+1;  //take diagonal + 1
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]); //take min of left from same row and right from above row
            }
        }
        return dp[m][n]; //return the final ans
    }

    public static void main(String[] args) {
        String str1 = "*@#*";
        String str2 = "*#";

        System.out.println(build_bridges(str1,str2));
    }
}


//T.C- O(m*n)
//S.C- O(m*n)
