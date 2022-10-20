import java.util.ArrayList;

public class q112 {
    //Help The Old Man!!!
    //Recursion,Tower Of Hanoi
    //01/06/2022

    static ArrayList<Integer> towerOfHanoi(int numberOfPlates,int nthMove){
        int count[]=new int[1];
        ArrayList<Integer> al=new ArrayList<>();
        towerOfHanoiHelper(numberOfPlates,nthMove,1,3,2,al,count);
        return al;
    }
    static void towerOfHanoiHelper(int numberOfPlates,int nthMove,int box1,int box2, int box3, ArrayList<Integer> al, int count[]){
        if(numberOfPlates==0) return;
        towerOfHanoiHelper(numberOfPlates - 1,nthMove,box1,box3,box2,al,count);
        count[0]++;
        if(count[0]==nthMove){
            al.add(box1);
            al.add(box2);
        }
        towerOfHanoiHelper(numberOfPlates - 1, nthMove, box3, box2, box1, al, count);
    }

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(3,4));
    }
}


//T.C - O(2^N)
//S.C - O(1)