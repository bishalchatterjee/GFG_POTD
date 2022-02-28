public class q16 {
    //Robots
    //String, Implementation
    //Date-25/02/2022

    static String moveRobots(String s1, String s2) {
        int i = 0, j = 0;
        int n = s1.length(); //get length
        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') {  //count number of '#'
                i += 1;
            }
            while (j < n && s2.charAt(j) == '#') {
                j += 1;
            }
            if(i<n && j<n) {
                if (s1.charAt(i) != s2.charAt(j)) return "No";
                else {
                    if (s1.charAt(i) == 'B' && i > j) return "No";
                    else if (s1.charAt(i) == 'A' && i < j) return "No";
                    else {
                        i += 1;
                        j += 1;
                    }
                }
            }
            else break;
        }
        return(i==n || j==n)?"Yes":"No";
    }
    public static void main(String[] args) {
        String s1="#B#A#";
        String s2="#A#B#";
        System.out.println(moveRobots(s1,s2));
    }
}
