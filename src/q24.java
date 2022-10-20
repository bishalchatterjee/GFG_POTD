public class q24 {
    //Maximum Winning Score
    //Binary Search Tree
    //Date-05/03/2022


    /*
    class Node{

      int data;
      Node left;
      Node right;
      Node(int data){
      this.data=data;
      left=null;
      right=null;
      }
   }

     static Long findMaxScore(Node root)
    {
        long l=0,r=0;
        if(root.left==null&&root.right==null)
            return Long.valueOf(root.data);
        if(root.left!=null)
            l=findMaxScore(root.left);
        if(root.right!=null)
            r=findMaxScore(root.right);
        return Math.max(l,r)*root.data;
    }
     */
}


//T.C-O(N)
//S.C-O(Height of the tree)