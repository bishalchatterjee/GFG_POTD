import java.util.Arrays;

public class q56 {
    //Maximum Selections
    //Sorting , Matrix
    //Date - 06/04/2022

    static int maxNonOverlapping(int ranges[][] , int n){

        Arrays.sort(ranges,(a,b)->a[1]-b[1]);  //sorting the array in ascending value of "b" in pair (a,b) in matrix of pairs "ranges" with custom comparator

//        System.out.println(Arrays.deepToString(ranges));  //debugging

        int count = 1;  //count variable initialised with 1
        int val=ranges[0][1];

        for(int i=0;i<n-1;i++){
            if(val<=ranges[i+1][0]){
                count++;
                val=ranges[i+1][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int ranges[][]={{1,5},
                        {2,3},
                        {1,8},
                        {3,5}};

        int n=4;
        System.out.println(maxNonOverlapping(ranges,n));
    }
}


//T.C - O(nlogn)
//S.C - O(1)