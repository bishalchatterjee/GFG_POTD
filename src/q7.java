import java.util.HashMap;

public class q7 {
    //Find rectangle with corners as 1 in NxM Matrix.
    //Matrix
    //Date-16/02/2022

    static boolean ValidCorner(int matrix[][]){
        int rows= matrix.length; //getting number rows of the matrix
        int columns= matrix[0].length; //getting number of columns of the matrix

        HashMap<Integer,Integer> mapX=new HashMap<>();
        HashMap<Integer,Integer> mapY=new HashMap<>();
        for (int i = 0; i < rows ; i++) {
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    mapX.put(i, mapX.getOrDefault(i,0)+1);
                    mapY.put(j, mapX.getOrDefault(j,0)+1);
                }
            }
        }
        int cntx = 0, cnty = 0;
        for(int k : mapX.keySet()) if(mapX.get(k) >= 2) cntx++;
        for(int k : mapY.keySet()) if(mapY.get(k) >= 2) cnty++;
        return (cntx >= 2 && cnty >= 2);
    }

    public static void main(String[] args) {
        int matrix[][]={{1,0,0,1,0},
                        {0,0,1,0,1},
                        {0,0,0,1,0},
                        {1,0,1,0,1}
        };
        System.out.println(ValidCorner(matrix));
    }
}
