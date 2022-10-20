import java.util.Arrays;

public class q23 {
    //Can Make Triangle
    //Mathematical, Geometry
    //Date-04/03/2022
    static int[] canMakeTriangle(int A[], int N)
    {
        int []res=new int [N-2];  //as per question we make result array of n-2
        for (int i = 0; i < N-2; i++) {         //we run a loop from 0 to n-2  //for example if the N=4 the loop will run form 0 to 1
            if(A[i]+A[i+1]>A[i+2] && A[i]+A[i+2]>A[i+1] && A[i+1]+A[i+2]>A[i])  //check for conditions to form a valid triangle as per question ie the respective side lengths should be a+b>c ,a+c>b , c+b>a
                res[i]=1; //if true then add 1 to ith  index of res array
            else res[i]=0; //else 0
        }
        return res;  //finally,return res array
    }

    public static void main(String[] args) {
        int N=4;
        int A[]={1,2,2,4};
        System.out.println(Arrays.toString(canMakeTriangle(A,N)));
    }
}
