import java.util.Deque;
import java.util.LinkedList;

class Node15{
    int data;
    Node15 next;
    Node15(int d) {
        data = d;
        next = null;
    }
}
public class p52 {
    //Move All Zeros To The Front Of The Linked List
    //LinkedList , Deque
    //Date-02/04/2022

    static Node15 moveZeroesInLinkedList(Node15 head) {
        Deque<Integer> dq = new LinkedList<Integer>(); //Double-Ended queue (deque)
        Node15 curr=head;   //store the original head of the linkedList
        while(curr!=null) {   //while current is not null
            if (curr.data == 0) {   //get the data of current node , if its 0 then add it to the first(start) of the deque
                dq.addFirst(curr.data);
            } else {
                dq.addLast(curr.data); // if it's not equal to 0 then add it to the last(end) of the deque
            }
            curr=curr.next;   // move to the next node
        }

        curr=head;// retrieve the original head of  LL

        while(curr!=null && !dq.isEmpty()){   //if the curr is not null and deque is not empty
            curr.data=dq.removeFirst();   //get the data from the deque and update the new date to current node
            curr=curr.next;               //go to next node
        }
        return head;//return the new head
    }
    static void printList(Node15 head)  // printList Function prints  the LL
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node15 head=new Node15(1);
        head.next=new Node15(4);
        head.next.next=new Node15(0);
        head.next.next.next=new Node15(5);
        head.next.next.next.next=new Node15(0);
        head.next.next.next.next.next=new Node15(0);


        Node15 res_head=moveZeroesInLinkedList(head);  //getting the new head
        printList(res_head);  //passing new head to print list function

    }
}


//T.C - O(n)   //as deque does O(1) insertion deletion  + O(n) as we traverse through all the nodes in the Linked-List
//S.C - O(n)