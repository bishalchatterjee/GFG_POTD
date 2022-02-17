class Node1{
    int data;
    Node1 left;
    Node1 right;
    Node1(int x){
        data=x;
        left=right=null;
    }
}

public class q8 {
    //Corona Vaccine
    //Trees
    //Date-17/02/2022

    //Logic:-
    // -1 is for need of vaccine because not covered by any vaccine or not have its own vaccine
    // 0 is for having a vaccine
    // 1 is for covered by other vaccine
    static int vaccineCount=0; // initialising vaccineCount

    static int DFS(Node1 root) { //we use depth first search because it has bottom up manner traversal advantage
        if (root == null) {
            return 1; // if root is null then we assume it's already covered by parent or child
        }

        int leftChild = DFS(root.left); //We do DFS for left Child  to check if it is cover/having vaccine or no vaccine
        int rightChild = DFS(root.right);// We do DFS for right child  to check if it is cover/having vaccine or no vaccine

        if (leftChild == -1 || rightChild == -1) {// if any of the children doesn't have the vaccine then we have supply a vaccine and increment the vaccineCount
            vaccineCount++;
            return 0; //since we supplied vaccine then it now has
        }
        if (leftChild == 0 || rightChild == 0) { // if any of them are having vaccine then return 1 as they are covered
            return 1;
        }

        return -1; //else return -1 as they are not covered nor do they have their own vaccine
    }

    static int supplyVaccine(Node1 root){ // main supply check function
        vaccineCount=0;  // reinitialise vaccine count
        if(DFS(root)==-1) {  //if the DFS(root) returns -1 then the root doesn't have its own vaccine and also not covered
            vaccineCount++; // increment the vaccine count
        }
        return vaccineCount;  // final answer containing the minimum number of vaccine required for the given tree
    }

    public static void main(String[] args) {

        Node1 root=new Node1(1);
        root.left=new Node1(2);
        root.right=new Node1(3);
        root.right.right=new Node1(4);
        root.right.right.right=new Node1(5);
        root.right.right.right.right=new Node1(6);


        System.out.println(supplyVaccine(root));
    }
}

//T.C- O(n) , n = number of nodes
