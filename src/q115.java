import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q115 {
    //Villain Con
    //DFS,Graph,Topological Sort
    //04/06/2022

    static int minColor(int N,int M,int mat[][]) {
        //Khans algo

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N];
        for (int i = 0; i < mat.length; i++) {
            int u = mat[i][1] - 1;
            int v = mat[i][0] - 1;
            adj.get(u).add(v);
            indegree[v]++;
        }

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        int minColor = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minColor++;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int element : adj.get(curr)) {
                    indegree[element]--;
                    if (indegree[element] == 0)
                        queue.add(element);
                }
            }
        }
        return minColor;
    }

    public static void main(String[] args) {
        int N = 5;
        int M = 6 ; //represents relation between minions (ie the size of matrix)
        int[][] mat = {{1, 3},
                {2, 3},
                {3, 4},
                {1, 4},
                {2, 5},
                {3, 5}};
        System.out.println(minColor(N,M,mat));
    }
}
