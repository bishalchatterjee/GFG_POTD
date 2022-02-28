public class q18 {
    //Smallest Window Containing 0's,1's,2's
    //Sliding Window, Two Pointer, String
    //27/02/2022
       static int smallestSubstring(String S) {
        // Code here
        boolean answerExist = false;
        int lastZero = -1, lastOne = -1, lastTwo = -1;  //initialize as not visited
        int ans = S.length();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '0')    lastZero = i;  //store index of last visited 0
            else if(S.charAt(i) == '1')   lastOne = i; //store index of last visited 1
            else    lastTwo = i; //store index of last visited 2
            if(lastZero != -1 && lastOne != -1 && lastTwo != -1) { //if the index of last visited of 0,1,2 is already found that means we have our window
                answerExist = true; //mark it as ans found
                ans = Math.min(ans, 1 + i - Math.min(lastZero, Math.min(lastOne, lastTwo)));  //get the min of ans and min(last visited 0 ,min(last visited 1 , last visited 2);
            }
        }
        if(answerExist)    return ans;  //result found return ans
        return -1; //if result not found we return -1 as per the question
    }
    public static void main(String[] args) {
        String S = "01212";
        System.out.println(smallestSubstring(S));
    }
}
//T.C- O(n)

/*
Alternative way

    static int smallestSubstring(String S) {
        // Code here
        int res=Integer.MAX_VALUE;
        int a=0, b=0, c=0, j=0;
        for(int i=0; i<S.length(); i++)
        {
            if(S.charAt(i) == '0')
                a++;
            else if(S.charAt(i)  == '1')
                b++;
            else if(S.charAt(i)  == '2')
                c++;
            while(a>0 && b>0 && c>0){
                res=Math.min(res, i-j+1);
                if(res==3)  return 3;
                if(S.charAt(j)  == '0')
                    a--;
                else if(S.charAt(j)  == '1')
                    b--;
                else if(S.charAt(j) == '2')
                    c--;
                j++;
            }
        }
        if(res==Integer.MAX_VALUE)
            return -1;
        return res;
    }
 */