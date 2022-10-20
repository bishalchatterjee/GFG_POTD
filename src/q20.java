import java.util.HashMap;
import java.util.Map;

public class q20 {
    //Concatenate Two Numbers
    //HashMap
    //01/03/2022

    static long countPairs(int N, int X, int numbers[]) {
        Map<String, Integer> hm = new HashMap<>(); //create a hashmap of string and integer pair (Key-->Value) pair

        for (int i = 0; i < N; i++) {   // N is the given length of the numbers array
            if (hm.containsKey("" + numbers[i]))   // if the element at number[i] is already present we increment the value by 1
                hm.put("" + numbers[i], hm.get("" + numbers[i]) + 1);
            else
                hm.put("" + numbers[i], 1); //else if the current element is not present in the hashmap add it to hashmap with value 1
        }
        long count = 0; //initialize count
        String x = new String("" + X);  //converting the int X(the number to be matched ) to String by adding it to a null string
        int len = x.length(); //get length of the above variable
        for (int i = len - 1; i >= 0; i--) {  //run a loop from len-1 to 0
            String a = x.substring(0, i);  //get the substring (0,i) , where 0-->is the start index (inclusive) & i--> is the end index (exclusive)
            String b = x.substring(i); //get the substring from index i till the end of the string
            if (!a.equals(b)) {//if a==b
                int f = hm.getOrDefault(a, 0); //check if a is present in the HashMap then get the value of the key ; if not present then put default ie 0
                int s = hm.getOrDefault(b, 0); //check if b is present in the HashMap then get the value of the key ; if not present then put default ie 0
                count += f * s;  //increment the count by f*s
            } else { //if a!=b
                int f = hm.getOrDefault(a, 0); //check if a is present in the HashMap then get the value of the key ; if not present then put default ie 0
                count += f * (f - 1); //increment the count by f*(f-1)
            }
        }
        return count; //return count
    }

    public static void main(String[] args) {
        int N = 4;
        int numbers[] = {1, 212, 12, 12};
        int X = 1212;
        System.out.println(countPairs(N,X,numbers));
    }

}
