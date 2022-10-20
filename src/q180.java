public class q180 {
    //Josephus Problem
    //Recursion
    //Date-08/08/2022

    static int josephusProblem(int n,int k){
        int winner=0;
        if(n==1)
            winner=1;
        else
            winner=josephusProblem(n-1,k)%n+1;
        return winner;
    }

    public static void main(String[] args) {
        int n=3,k=2;
        System.out.println(josephusProblem(n,k));
    }
}

//T.C - O(n)
//S.C - O(1)