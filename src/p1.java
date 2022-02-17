public class p1 {
    //XOR Game
    //Mathematical
    //Date-10/02/2022
        static int xorCal(int k){
            // code here
            for(int i=1; i<100; i++)
            {
                int x = i^(i+1);
                if(x==k)
                {
                    return i;
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        int k=3;
        System.out.println(xorCal(k));
    }
}

//T.C- O(1)
//A.S- O(1)
