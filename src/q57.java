public class q57 {
    //LCP [Longest Common Prefix in array of strings]
    //Strings , Prefix
    //Date - 07/04/2022

    static String findLCP(String s[],int n){
        String prefix=s[0];  //store the first string from the array of strings
        int len=s.length;

        for (int i = 1; i <len; i++) {
//            System.out.println(s[i].indexOf(prefix)); //debugging
            while (s[i].indexOf(prefix)!=0){  //Until the next string contains this substring.
                prefix = prefix.substring(0,prefix.length()-1); //we should cut down the prefix a little bit (remove the last character)
//                System.out.println(prefix); //debugging
            }
        }
        if(prefix.isEmpty()) return "-1"; //if prefix is empty then return null [here -1 as per question]

        return prefix;
    }

    public static void main(String[] args) {
        String s[]={"geeksforgeeks", "geeks", "geek", "geezer"};

        System.out.println(findLCP(s,s.length));
    }

}


//T.C - O(len)
//S.C - O(1)


//Alternate Appraoch
//    public String longestCommonPrefix(String[] a)
//    {
//        int size = a.length;
//
//        /* if size is 0, return empty string */
//        if (size == 0)
//            return "";
//
//        if (size == 1)
//            return a[0];
//
//        /* sort the array of strings */
//        Arrays.sort(a);
//
//        /* find the minimum length from first and last string */
//        int end = Math.min(a[0].length(), a[size-1].length());
//
//        /* find the common prefix between the first and
//           last string */
//        int i = 0;
//        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
//            i++;
//
//        String pre = a[0].substring(0, i);
//        return pre;
//    }


//O(max*nlogn)
//O(prefix length)
