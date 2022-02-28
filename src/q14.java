class Node2{
    int data;
    Node2 next;
    Node2(int d){
        data=d;
        next=null;
    }
}


public class q14 {
    //Insertion Sort For Singly LinkedList
    //Sorting, LinkedList
    //Date-23/02/2022

    static Node2 insertionSort(Node2 head){
        Node2 dummy = new Node2(-1);
        Node2 curr= head;

        while(curr!=null) {
            Node2 temp = curr.next;
            Node2 prev = dummy;
            Node2 nxt = dummy.next;

            while (nxt != null) {
                if (nxt.data > curr.data) {
                    break;
                }
                prev = nxt;
                nxt = nxt.next;
            }
            curr.next = nxt;
            prev.next = curr;
            curr = temp;
        }
        return dummy.next;
    }
    //printing funtion
    static void printLinkedList(Node2 head){
        Node2 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node2 head=new Node2(20);
        head.next=new Node2(10);
        head.next.next=new Node2(80);
        head.next.next.next=new Node2(70);
        head.next.next.next.next=new Node2(30);

        Node2 ans=insertionSort(head);
        printLinkedList(ans);

    }
}


//T.C - O(n^2)  { Clearly because of nested while loops
//S.C- O(1)     { we are making a few nodes/variables which are constant extra space