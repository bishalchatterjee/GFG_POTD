import java.util.ArrayList;

public class q114 {
    //Tricky Subset Problem
    //Greedy
    //03/06/2022

        static int isPossible(long S, int N, long X, long A[]) {

            ArrayList<Long> al = new ArrayList<>();
            al.add(S);  //adding the first element ie S to the array list
            long sum = 0;
            long current_sum = 0;
            al.add(S + A[0]);  //storing the second element of the possible sequence
            current_sum = al.get(0) + al.get(1); //current sum
            for (int i = 1; i < N; i++) {  //starting form second element in the array
                sum = A[i] + current_sum;   //calculate the sum
                if (sum > X) {  //if sum > X there's no point in proceeding further as we need to find out if X can be formed using elements in al (arraylist)
                    break;
                }
                al.add(sum);  //add the sum to al
                current_sum += sum;  //increment the current_sum by the calculated sum
            }
            //checking if there's any possible combination in the arraylist that forms the number X
            int res = 0;
            for (int i = al.size() - 1; i >= 0; i--) {
                if (al.get(i) > X) { //the element cannot be greater than X
                    continue;  //skip it
                } else {
                    X -= al.get(i); //Subtracting the elements of the arraylist to check if X becomes 0
                }
                if (X == 0) {  //if yes then the combination to form X must have existed
                    return 1; //(1 - Yes , 0 - No)
                }
            }
            return res;  //return res
        }

    public static void main(String[] args) {
        long A[]={1, 2, 4, 2};
        System.out.println(isPossible( 1,  4, 7,A));
    }
}


//T.C - O(N)
//S.C - O(N)