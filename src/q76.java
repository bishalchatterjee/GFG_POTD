public class q76 {
    //Eulerian Path in an Undirected Graph
    //Graph
    //Date- 26/04/2022

    /*
    Check if the given adjacency matrix consists of eulerian path
    This TED-ed riddle will help you understand the problem: https://www.youtube.com/watch?v=VrqBX-Tck2A
     */

    static boolean eulerPath(int graph[][], int n){
        int evenDeg=0,oddDeg=0;

        for (int i = 0; i < n ; i++) {  //traverse each row
            int count = 0;       //to keep count of number of 1's
            for (int j = 0; j <n ; j++) {
                if(graph[i][j]==1) count++;  //if the current element is 1 increment the count
            }
            if(count%2==0) evenDeg++; //if the count is even then increment the evenDegree count
            else
                oddDeg++; //else increment the oddDegree count
        }
        //Is it a Eulerian Circuit?
        if(evenDeg==n) return true;  //if the evenDeg matches with the length of the row/column then there exists a eulerian path

        //If it is not a Eularian Circuit then does
        //it have a single start and end point?
        //If yes then it is an Eulerian path!
        if(oddDeg==2) return true;  //the start and exit point exceptions in an eularian circuit

        return false;
    }

    public static void main(String[] args) {
        int graph[][]={{0, 1, 0, 0, 1},
                       {1, 0, 1, 1, 0},
                       {0, 1, 0, 1, 0},
                       {0, 1, 1, 0, 0},
                       {1, 0, 0, 0, 0}};

        int n= graph.length;
        System.out.println(eulerPath(graph,n));
    }
}
//T.C - O(N*N) OR  O(N^2)
//S.C - O(1)