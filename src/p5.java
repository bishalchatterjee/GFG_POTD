import java.util.Arrays;

public class p5 {
    //Find Missing and Repeating Numbers
    //Arrays [Medium]
    //Date-14/02/2022
    static int[] findTwoElement(int arr[], int n) {
        int repeating_number=0,missing_number=0;
        int temp[]=new int[n+1];// temp array containing count of frequency of each element of arr[] //initially all indexes are 0
        int res[]=new int[2];//since the output is having repeating and missing numbers and type is array

        for (int i = 0; i <n ; i++) {
            temp[arr[i]]++; //incrementing the frequency count of each element of arr[i] from 0; the missing number will have 0(default) frequency;Non repeating numbers will have frequency as 1;  Repeating number will have 2 frequency;
        }
        for (int i = 1; i <=n ; i++) { // loop starts from 1 as per question
            if(temp[i]==0) // if frequency of current element is 0 --> so the element was missing for sure
                missing_number=i;//store that number in the missing_number variable
            else if(temp[i]==2)//if frequency is 2 then it is the repeating number
                repeating_number=i;
        }
        res[0]=repeating_number; // organise as per output format ie--> repeating number followed by missing number form the array
        res[1]=missing_number;
        return res; // returning the result array
    }

    public static void main(String[] args) {
        int arr[]={2,2};
        int n= arr.length;
        System.out.println(Arrays.toString(findTwoElement(arr,n))); //using Arrays.toString to directly get it printed
    }
}

//T.C- O(n)
//S.C- O(1)

