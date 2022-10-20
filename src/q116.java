public class q116 {
    //Bike Racing
    //BinarySearch[Advance]
    //05/06/2022

    //Explanation:- https://www.youtube.com/watch?v=j89m-H66Xlg

    static long buzzTime(long N, long M, long L, long H[], long A[]) {
        long low=0; // low
        long high=Math.max(L,M); //or long high=(long)1e10;  //high
        long ans=0; //to store answer

        while (low<=high){ //start binary search
            long mid=low+(high-low)/2; //finding the mid
            long fast_biker=0;

            for (int i = 0; i < N ; i++) {
                //H[i]+A[i]*mid --> gives the speed of the bike at mid(th) hour //initial speed + acceleration * current_hour
                if(H[i]+A[i]*mid>=L)  //if the speed of the current biker i is >= the given threshold ie L--> Then it's a fast biker
                    fast_biker+=H[i]+A[i]*mid;  //sum of all fast bikers
            }
            if(fast_biker>=M){ //check if the sum of all fast bikers exceed or equates with M [ that triggers the alarm/buzz of the track]
                ans=mid;  //store the mid as it's a potential answer but since we need to find minimum of all possible answers
                high=mid-1; // we reduce the high window to find a better(smaller) answer
            }
            else low=mid+1; //otherwise, increase the low window as anything below low can't be out answer since low is < M
        }
        return ans;  //finally, return the answer
    }

    public static void main(String[] args) {
        long N = 3, M = 400, L = 120;
        long[] H = {20, 50, 20};
        long[] A = {20, 70, 90};

        System.out.println(buzzTime(N,M,L,H,A));
    }
}


//T.C -O(n*log(max(l,M)) or O(n log n)
//S.C -O(1)