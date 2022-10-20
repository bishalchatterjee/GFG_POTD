public class q186 {
    //Friends Pairing Problem
    //DP
    //Date-14/08/2022

    static long pairFiends(int n){
        if(n<=2) return n;
        int mod=1000000007;
        int dp[]=new int[n+1];
        dp[1]=1; //if there is only friend --> {1}
        dp[2]=2; //if there are two friends ten they can be paired either of two ways --> i) {1},{2}  ii){1,2}

        for (int i = 3; i <=n  ; i++) { //start from 3
            dp[i]=(dp[i-1]+(dp[i-2]*(i-1)))%mod;  //dp[ith friend] =dp[ith-1] + dp[ith-2]*(i-1)
        }
        return dp[n]%mod;
    }

    public static void main(String[] args) {
        int n=6;
        System.out.println(pairFiends(n));
    }
}


//T.C - O(n)
//S.C - O(n)