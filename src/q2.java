public class q2 {
    //Remove Leading Zeros From an IP address
    //Strings
    //Date-11/02/2022
    static String newIPAdd(String S) {
        StringBuilder ans = new StringBuilder();

        boolean flag = true;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '.') {
                flag = true;
                ans.append('.');
            } else if (flag && S.charAt(i) == '0') {
                if (i == S.length() - 1 || S.charAt(i + 1) == '.') ans.append('0');
            } else {
                ans.append(S.charAt(i));
                flag = false;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String S="100.020.003.400";
        System.out.println(newIPAdd(S));
    }
}

//T.C - O(LENGTH)
