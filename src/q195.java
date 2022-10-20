class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(int val){
        this.val=val;
        right=left=null;
    }
}

public class q195 {
    //Check if Tree is Foldable
    //Binary Tree
    //Date-23/08/2022

    static boolean isFoldableBST(TreeNode root){
        if(root==null)
            return true;

        return helper(root.left,root.right);
    }

    static boolean helper(TreeNode left,TreeNode right){
        if(left==null || right==null)
            return (left==right);

       return helper(left.left,right.right) & helper(right.left,left.right); // OR helper(right.right,left.left) & helper(right.left,left.right)
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(7);
        root.left.right=new TreeNode(9);
        root.right=new TreeNode(15);
        root.right.left=new TreeNode(11);


        System.out.println(isFoldableBST(root));
    }
}
