import java.util.ArrayList;
import java.util.Collections;

public class q11 {
    //Smallest Absolute Difference
    //Arrays
    //Date-20/02/2022


    static long kthDiff(long arr[], long n, long k)
    {
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                al.add((int)Math.abs(arr[(int)i]-arr[(int)j]));
            }
        }
        Collections.sort(al);
        return (al.get((int)(k-1)));
    }

    public static void main(String[] args) {
//        int n=2,k=1;
        int n=4,k=3;
//        long arr[]={10,10};
        long arr[]={1,2,3,4};
        System.out.println(kthDiff(arr,n,k));
    }
}

//O(n log n)


/*
C++ Binary Search Based Solution

int countPairs(int *a, int n, int mid) {
    int res = 0;
    for (int i = 0; i < n; ++i)

        // Upper bound returns pointer to position
        // of next higher number than a[i]+mid in
        // a[i..n-1]. We subtract (a + i + 1) from
        // this position to count
        res += upper_bound(a + i, a + n, a[i] + mid) - (a + i + 1);
    return res;
}

// Returns k-th absolute difference
int kthDiff(int a[], int n, int k) {
    // Sort array
    sort(a, a + n);

    // Minimum absolute difference
    int low = a[1] - a[0];
    for (int i = 1; i <= n - 2; ++i) low = min(low, a[i + 1] - a[i]);

    // Maximum absolute difference
    int high = a[n - 1] - a[0];

    // Do binary search for k-th absolute difference
    while (low < high) {
        int mid = (low + high) >> 1;
        if (countPairs(a, n, mid) < k)
            low = mid + 1;
        else
            high = mid;
    }

    return low;
}

 */