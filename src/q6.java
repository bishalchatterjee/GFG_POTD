public class q6 {
    //Anagram of a String
    //Strings
    //Date-15/02/2022
    static int removeAnagrams(String s1,String s2)
    {
        int[] count = new int[26];

        int res = 0;
        //store frequencies of first array
        for(int i = 0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
        }
        //store frequencies of second array
        for(int i = 0;i<s2.length();i++){
            count[s2.charAt(i)-'a']--;
        }
        //count the no of char to be deleted
        for(int i = 0;i<26;i++){
            res+=Math.abs(count[i]);
        }

        return res;

    }

    public static void main(String[] args) {
        String s1="chgeeks";
        String s2="geek";
        System.out.println(removeAnagrams(s1,s2));
    }
}
