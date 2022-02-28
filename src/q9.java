import java.util.Arrays;

public class q9 {
    //Rearrange Geek and His Classmates
    //Arrays
    //Date-18/02/2022

    static void prank(long a[],int n){
        long temp[]=new long[n];  // temp array initialization
        int newIndex=0;
        for (int i = 0; i < n ; i++) {
            newIndex = (int) a[i]; //newIndex for the element to be placed at temp[i]
            temp[i] = a[newIndex]; // filling temp i with the a[newIndex]
        }
        for (int i = 0; i < n; i++) {
            a[i]=temp[i];  //copying elements to original array
        }
        System.out.println(Arrays.toString(a)); //printing the array
    }

    public static void main(String[] args) {
        long a[]={0, 5, 1, 2, 4, 3};
        int n=6;
        prank(a,n);
    }
}
