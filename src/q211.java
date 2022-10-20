import java.util.PriorityQueue;

class TreeNode16{

    int val;
    TreeNode16 left,right;

    TreeNode16(int val){
        this.val=val;
        left=right=null;
    }
}
public class q211{
    //
    //
    //

    static int sumOfKSmallest(TreeNode16 root,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        inOrderHelper(root,pq);

        int sum=0;
        while(k!=0){
            sum+=pq.poll();
            k--;
        }
        return sum;
    }
    static void inOrderHelper(TreeNode16 root, PriorityQueue<Integer> pq){
        if(root == null) return;

        inOrderHelper(root.left,pq);
        pq.add(root.val);
        inOrderHelper(root.right,pq);
    }

    public static void main(String[] args) {
        TreeNode16 root=new TreeNode16(9);
        root.left=new TreeNode16(4);
        root.left.right=new TreeNode16(2);
        root.right=new TreeNode16(6);
        root.right.left=new TreeNode16(1);
        root.right.right=new TreeNode16(3);


        int k=3;

        System.out.println(sumOfKSmallest(root,k));
    }
}
