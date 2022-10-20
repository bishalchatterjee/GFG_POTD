public class q21 {
    //Exactly One Swap
    //Strings
    //Date-2/03/2022

    static long getExactOneSwapCount(String s){
        int n=s.length();
        int arr[]=new int[26];
        for (int i = 0; i <n ; i++) {
            arr[s.charAt(i)-'a']++;
        }
        long ans=0;
        for (int i = 0; i <n; i++) {
            ans+=n-arr[s.charAt(i)-'a'];
        }
        ans/=2;

        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 2) {
                ans++;
                break;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s="geek";
        System.out.println(getExactOneSwapCount(s));
    }
}
