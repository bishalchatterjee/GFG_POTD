import java.util.ArrayList;
import java.util.Arrays;

public class q199 {
    //Alternate positive and negative numbers
    //Arrays
    //Date-27/08/2022

    static int[] rearrangeArrayWithAlternatingPositiveNegative(int[] arr){
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int ele: arr) {
            if(ele<0)
                neg.add(ele);  //-ve
            else
                pos.add(ele); //+ve
        }
        int i=0; //for counting total length as we are modifying the original array
        int ind=0; //for index


        while(i<pos.size() && i<neg.size()) { //while either of the elements gets exhausted
            arr[ind]=pos.get(i);  //since the staring element should be +ve
            ind++;
            arr[ind]=neg.get(i);
            i++;
            ind++;
        }
        while(i<pos.size()) {  //if positive elements gets over then put the remaining into the arr
            arr[ind]=pos.get(i);
            i++;
            ind++;
        }
        while(i<neg.size()) {  //if negative elements gets over then put the remaining into the arr
            arr[ind]=neg.get(i);
            i++;
            ind++;
        }

        return arr;
    }

    public static void main(String[] args) {
        int arr[]={9, 4, -2, -1, 5, 0, -5, -3, 2};
        System.out.println(Arrays.toString(rearrangeArrayWithAlternatingPositiveNegative(arr)));
    }
}


//T.C - O(n)
//S.C - O(n)
