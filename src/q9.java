import java.util.Arrays;

public class q9 {
    //Rearrange Geek and His Classmates
    //Arrays
    //Date-18/02/2022

    static void prank(long a[],int n){
        long temp[]=new long[n];
        int index=0;
        for (int i = 0; i < n ; i++) {
            index = (int) a[i];
            temp[i] = a[index];
        }
        for (int i = 0; i < n; i++) {
            a[i]=temp[i];

        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        long a[]={0, 5, 1, 2, 4, 3};
        int n=6;
        prank(a,n);
    }
}
