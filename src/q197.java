import java.util.ArrayList;
import java.util.Arrays;

public class q197 {
    //Counting elements in two arrays
    //Arrays, Binary, SearchSearching
    //Date- 25/08/2022s
    static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        // add your code here
        ArrayList<Integer> res=new ArrayList<>();
        Arrays.sort(arr2);

        for(int i:arr1)
            res.add(binarySearchHelper(i,arr2,n));

        return res;
    }
    static int binarySearchHelper(int x,int arr[],int n){
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]<=x)
                low=mid+1;
            else
                high=mid-1;
        }

        return low;
    }

    public static void main(String[] args) {
        int m = 6, n = 6;
        int arr1[] = {1,2,3,4,7,9};
        int arr2[] = {0,1,2,1,1,4};

        System.out.println(countEleLessThanOrEqual(arr1,arr2,m,n));
    }
}


//T.C -O(nlogn)
//S.C -O(1)