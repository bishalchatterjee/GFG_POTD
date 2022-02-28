import java.util.HashMap;
public class q19 {
    //Hit Most Balloons
    //Mathematical,Geometry,HashMap
    //Date-28/02/2022

    static int hitMostBalloons(int N, int arr[][]) {
        // Code here
        int ans = 0;// initialize ans
        for (int i = 0; i < N; i++) {
            int x1 = arr[i][0], y1 = arr[i][1];   //get the x1,y1 value at  i'th index element form arr[][]
            HashMap<Double, Integer> hm = new HashMap<>(); //new hashmap
            int count = 0; //count initialization
            for (int j = 0; j < N; j++) //second loop
            {
                int x2 = arr[j][0], y2 = arr[j][1]; //get the x2,y2 value at j'th index from arr[][]
                if (x1 == x2 && y1 == y2) //if they match
                {
                    count++; //increment count
                    continue; //skip remaining statements
                }
                double tan_theta = (y2 - y1) / (1.0 * (x2 - x1)); //count slope with classic slope calculation formula
                hm.putIfAbsent(tan_theta, 0);   //put if not present calculated slope with key 0
                hm.put(tan_theta, hm.get(tan_theta) + 1); //put slope with the key ((get current slope)+ 1)
            }
            for (double z : hm.keySet())  //for each loop
                ans = Math.max(ans, count + hm.get(z)); //ans=max ( (ans),(count+Current_key))
        }
        return ans;  //finally, return ans
    }

    public static void main(String[] args) {
        int N = 3;
        int arr[][] = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(hitMostBalloons(N, arr));
    }
}


//T.C -O(n^2)