import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Node16 {
    int data;
    Node16 left;
    Node16 right;

    Node16(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class q147 {

    static ArrayList<Integer> diagonalTraversalOfBinaryTree(Node16 root)
    {
        //add your code here.
        ArrayList<Integer> ans = new ArrayList<Integer>();
        diagonalUtil(root,ans);
        return ans;
    }
    static void diagonalUtil(Node16 root, ArrayList<Integer> ans){

        Queue<Node16> q = new ArrayDeque<Node16>();
        if(root != null){
            q.add(root);
        }

        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize-- > 0){
                Node16 node = q.poll();
                while(node != null){
                    ans.add(node.data);

                    if(node.left != null){
                        q.add(node.left);
                    }
                    node = node.right;
                }
            }
        }

    }

    public static void main(String[] args) {
        Node16 root=new Node16(8);
        root.left=new Node16(3);
        root.left.left=new Node16(1);
        root.left.right=new Node16(6);
        root.left.right.left=new Node16(4);
        root.left.right.right=new Node16(7);
        root.right=new Node16(10);
        root.right.right=new Node16(14);
        root.right.right.left=new Node16(13);

        System.out.println(diagonalTraversalOfBinaryTree(root));
    }

}
