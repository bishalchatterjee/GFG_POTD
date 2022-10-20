import java.util.ArrayList;
import java.util.Arrays;

public class q78 {
    //Shop in Candy Store
    //Greedy, Sorting
    //Date- 28/0/2022

    static ArrayList<Integer> candyStore(int candies[],int N,int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Arrays.sort(candies); // sort the array

        int min=0;  //min and max variables to add to the final arraylist
        int max=0;

        for (int i = 0; i < N ; i++) {
            min +=candies[i];  //get sum of element from the start of the candies array in min till the value of N is valid
            N=N-k;
//            System.out.println("min="+min+"N="+N);  //debugging statement
        }



        int index=0;   //maintain a index count
        for (int i = candies.length - 1; i>=index ; i--) {  //get sum of elements from the end of the candies array in max variable till index is valid
            max+=candies[i];
            index+=k;
//            System.out.println("max="+max+"index="+index);  //debugging statement
        }
        al.add(min);  //add min and max count to the result arraylist
        al.add(max);
        return al;   //return the arraylist

    }

    public static void main(String[] args) {
        int N=5,k=2;
        int candies[]={3,2,1,4};
        System.out.println(candyStore(candies,N,k));
    }
}

//T.C - O(n log n)
//S.C - O(1)