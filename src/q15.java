import java.util.ArrayList;
import java.util.List;

public class q15 {
    //Return two Prime Numbers
    //Mathematical
    //Date- 24/02/2022
    static boolean isPrime(int n)
    {
        //highly optimised for large numbers
        if(n==1)//If n=1 then it can't be prime
            return false;
        if(n==2 || n==3)//If n=2 or  n==3 then it is prime
            return true;
        if(n%2==0 || n%3==0)//Since 2 and 3 are prime so any number completely divisible by 2 or 3 it can't be prime  (as it will have more than 2 divisors including 1 and itself)
            return false;  //so return false
        for(int i=5; i*i<=n; i=i+6) { //start from 5
            if(n % i == 0 || n % (i + 2) == 0)  //optimization
                return false;
        }
        return true;
    }
    static List<Integer> primeDivision(int A){
        List<Integer> result = new ArrayList<Integer>(); //create result arraylist
        for(int i=2;i<=A;i++){ // we run from 2 to A
            if(isPrime(i) && isPrime(A-i)){ // if they are prime add them to arraylist  // i is the minimum prime and A-i the other prime both sum up to make A (the input prime)
                result.add(i);
                result.add(A-i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int A=74;
        System.out.println(primeDivision(A));
    }
}

//T.C- O(N*sqrt(N))
//A.S-  O(N)