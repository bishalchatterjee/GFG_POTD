import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q22 {
    //Matrix Operations
    //Matrix,Backtracking,Map
    //03/03/2022
    static boolean isSafe(int m,int n,int i,int j){ // Function to check if the indices (i, j)  are valid indices in a Matrix or not
        if(i<0) return false;
        if(j<0) return false;
        if(i>=m) return false;
        if(j>=n) return false;

        return true; // Otherwise, Return true
    }
    static int[] endPoints(int [][]arr,int m,int n){ //Function to find indices of cells of a matrix from which traversal leads to out of the matrix
        int i=0,j=0; //start from the cell (0,0)
        int current_i=0,current_j=0; //current index pointers

        char current_d='r'; //default direction is right

        //Stores direction changes
        Map<Character,Character> directions=new HashMap<>();
        directions.put('u','r');
        directions.put('r','d');
        directions.put('d','l');
        directions.put('l','u');

        while(isSafe(m,n,i,j)){ //iterate until the current cell exceeds beyond the matrix
            current_i=i;  //current index
            current_j=j;

            if(arr[i][j]==1){ //if the value of current cell is 1
                char move_in=directions.get(current_d);

                arr[i][j] = 0; //update the value af current cell to 0 //as per question

                if (move_in == 'u')   //update direction as per question
                    i -= 1;
                else if(move_in == 'd')
                    i += 1;
                else if(move_in == 'l')
                    j -= 1;
                else if(move_in == 'r')
                    j += 1;

                current_d = move_in;
            }
            else{ //otherwise

                if (current_d == 'u')  //update direction as per question
                    i -= 1;
                else if(current_d == 'd')
                    i += 1;
                else if(current_d == 'l')
                    j -= 1;
                else if(current_d == 'r')
                    j += 1;
            }
        }
        return new int[]{current_i, current_j}; // The exit coordinates
    }

    public static void main(String[] args) {
        int arr[][]={{0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 0}};
        int m= arr.length;
        int n=arr[0].length;
        System.out.println(Arrays.toString(endPoints(arr,m,n)));
    }
}
