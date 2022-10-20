import java.util.HashMap;

public class q117 {
    //Count pairs in array divisible by K
    //HashMap
    //06/06/2022

    static long countPairsDivisibleByK(int arr[], int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        long count = 0;

        for(int i=0;i<n;i++){
            int rem=arr[i]%k;  //get reminder of current element by dividing with k

            if(map.containsKey((k-(rem))%k))  //map contains the (k-(rem))%k (ie the second number along with rem that sum==k) //for example 2%4=2 so we need to find if map contains 4-2%4=2
                count+=(map.get((k-(rem))%k));  //increase the pair count

            map.put(rem,map.getOrDefault((rem),0)+1); //put the reminder, if present increase the frequency count otherwise put 0
        }
        return count; //return final pair count
    }

    public static void main(String[] args) {
        int[] arr={2, 2, 1, 7, 5, 3};int k = 4;
        System.out.println(countPairsDivisibleByK(arr,arr.length,k));
    }
}


//T.C- O(n)
//S.C- O(k)