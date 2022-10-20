import java.util.ArrayList;

class Node20 {
    Node20 left;
    Node20 right;
    int data;

    Node20(int d) {
        data = d;
        left = right = null;
    }
}
    public class q200 {
    //Binary Tree To Doubly Linked List
    //BinaryTree, Doubly Linked List
    //Date-28/08/2022

        static Node20 binaryTreeToDLL(Node20 root){
            ArrayList<Node20> res=new ArrayList<>();
            helperInorder(root, res);

            for (int i = 0; i < res.size()-1; i++) {
                Node20 curr=res.get(i);
                Node20 next=res.get(i+1);

                curr.right=next;
                next.left=curr;
            }
            return res.get(0);


        }
        static void helperInorder(Node20 root,ArrayList<Node20> al){
            if(root==null)
                return;
            helperInorder(root.left,al);
            al.add(root);
            helperInorder(root.right,al);
        }

        static void printlist(Node20 head) {
            while (head != null) {
                System.out.print(head.data);
                if(head.right!=null) System.out.print
                        (" <-> ");
                head=head.right;  //why right ?? --> as we dont have the node for linked list we use right of binary node class as next
            }
        }

        public static void main(String[] args) {
            Node20 root=new Node20(10);
            root.left=new Node20(20);
            root.left.left=new Node20(40);
            root.left.right=new Node20(50);
            root.right=new Node20(30);


            Node20 res=binaryTreeToDLL(root);
            printlist(res);
        }
}


//T.C - O(n) //n--> number of nodes
//S.C - O(h+n) //h--> height of the tree n-> for nodes in arraylist