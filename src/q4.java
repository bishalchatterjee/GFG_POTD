import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
}
public class q4 {
    //Largest value in each level.
    //Trees
    //Date-13/02/2022

    static ArrayList<Integer> largestValuesInEachLevelOfTree(Node root)
    {
        //code here
        ArrayList<Integer> al=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                Node cur=q.poll();
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
                if(cur.data>max)
                    max=cur.data;
            }
            al.add(max);
        }
        return al;
    }

    public static void main(String[] args) {

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);

        System.out.println(largestValuesInEachLevelOfTree(root));
    }
}
