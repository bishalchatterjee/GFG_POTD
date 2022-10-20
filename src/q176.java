import java.util.LinkedList;
import java.util.Queue;

class Node01{
    int data;
    Node01 left,right;
    Node01(int val){
        this.data = val;
        left=right=null;
    }
}
public class q176 {
    //Complete Binary Tree
    //BinaryTre,Queue
    //04/08/2022
    static boolean completeBinaryTree(Node01 root) {
        Queue<Node01> q = new LinkedList<Node01>();
        boolean flag = false;

        q.add(root);

        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Node01 rem = q.poll();
                if (rem == null) {
                    flag=true;
                    break;
                } else {
                    if (flag == true)
                        return false;
                    else {
                        q.add(rem.left);
                        q.add(rem.right);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node01 root=new Node01(1);
        root.left=new Node01(2);
        root.left.right=new Node01(4);
        root.right=new Node01(3);
        root.right.left=new Node01(5);
        root.right.right=new Node01(6);

        boolean res=completeBinaryTree(root);
        if(res==false)
            System.out.println("Not a complete Binary Tree");
    else
            System.out.println("Complete Binary Tree");
    }
}


//T.C - O(n) //because we are traversing at-most n nodes of the tree and each node can have 2 children
//S.C - O(n)