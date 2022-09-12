import javax.swing.*;

 class LinkedList {
    public  Node head = null; // Creating head and tail
    public  Node tail = null;

    static class Node{
        Object data; // initialize a data
        Node next; // initialize the next data
        Node prev; // initialize the prev data

        public Node(Object data) { // Constructor method
            this.data = data;
        }
    }


    public void insert(Object data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            head.prev = null; // heads prev will point to null as rule
            tail.next = null; // tail will points to null cause it's end of our list
        }
        else {
            tail.next = newNode; // new node will be added after tail
            newNode.prev = tail; // Newnode's prev will point to tail
            tail = newNode; // Now newNode is new tail of our list
            tail.next =null; // it'll point to null 'cause it's not circular
        }
    }


    public void display() {
        //Node current will point to head
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print(" Nodes of doubly linked list: ");
        while(current != null) {
            //Prints each node by incrementing the pointer.

            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void removeHead(LinkedList lnklist){ // It happens with O(1)
        lnklist.head = lnklist.head.next;
        lnklist.head.prev = null;
        System.out.print("\nAfter removing the head, ");
        lnklist.display();
    }

    public static void removeTail(LinkedList lnk){
    if(lnk.head == null){
        System.out.println("Linked list is Empty!");
    }
    else {
        lnk.tail = lnk.tail.prev;
        lnk.tail.next = null;
    }
    }
    public static void removeAtIndex(LinkedList lnk, int target){
        Node current = lnk.head;
        int count = 0;
        while (current != null){
            if(count == target-1){
                Node temp = current.next;
                current.next.prev = current.prev;
                current.next = temp;
                break;
            }
            count++;
            current = current.next;
        }
        lnk.display();
    }



    public static void main(String[] args){
        LinkedList lnk = new LinkedList();
        lnk.insert(25);
        lnk.insert(34);
        lnk.insert(35);
        lnk.insert("Ömer");
        lnk.insert(07);
        removeTail(lnk); // it'll delete the 7
        lnk.display();
        removeHead(lnk); // it'll delete the 25 as a head of our list
        removeAtIndex(lnk,1);

    }


}