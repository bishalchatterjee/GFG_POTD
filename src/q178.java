class ListNode{
    int data;
    ListNode next;
    ListNode prev;
    ListNode(int data){
        this.data=data;
    }
}

public class q178 {
    //QuickSort on Doubly Linked List
    //QuickSort (Hoare's Partition)
    //06/08/2022

    static void quickSortOnDoublyLinkedList(ListNode head) {
        ListNode end=findLastNode(head);
        ListNode start=head;

        quickSortHelper(start,end);
        printList(head);
    }
    static void quickSortHelper(ListNode start,ListNode end){
        if(end!=null && start!=end && start!=end.next){
            ListNode pivot=partition(start,end);
            quickSortHelper(start,pivot.prev);
            quickSortHelper(pivot.next,end);
        }
    }
    static ListNode partition(ListNode start,ListNode end){
        int pivot=end.data;
        ListNode temp1=start;
        ListNode temp2=start;

        while(temp1 != end){
            if(temp1.data<pivot){
                swapNodes(temp1,temp2);
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        swapNodes(temp2,end);
        return temp2;
    }
    static void swapNodes(ListNode temp1,ListNode temp2){
        int temp=temp1.data;
        temp1.data=temp2.data;
        temp2.data=temp;
    }

    static void printList(ListNode head){
        while(head !=null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print("->");
            head = head.next;
        }
    }
    static ListNode findLastNode(ListNode node){
        while(node!=null && node.next!=null)
            node=node.next;

        return node;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.prev=head;
        head.next.next=new ListNode(9);
        head.next.next.prev=head.next;


        quickSortOnDoublyLinkedList(head);


    }
}
