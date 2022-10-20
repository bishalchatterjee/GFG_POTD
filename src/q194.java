import java.util.Arrays;

public class q194 {
    //Immediate Smaller Element
    //Arrays
    //Date-22/08/2022

    static int[] immediateSmallerElementArray(int[] arr,int n){
        for (int i = 0; i < n-1; i++) {
            arr[i]=arr[i]>arr[i+1] ? arr[i+1] : -1;  //as per question --> change arr[i] to arr[i+1] is arr[i] is greater else put -1
        }
        arr[n-1]=-1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={4, 2, 1, 5, 3};
        System.out.println(Arrays.toString(immediateSmallerElementArray(arr, arr.length)));
    }
}

//T.C - O(n)
//S.C - O(1)
