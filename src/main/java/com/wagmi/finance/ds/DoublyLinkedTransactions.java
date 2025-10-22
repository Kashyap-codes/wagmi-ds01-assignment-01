package main.java.com.wagmi.finance.ds;

/*
 TODO[Student]: Doubly linked list of transactions
 - Implement tail-insert `add`, `deleteById`, `findById`, `reverse`, `toArray`.
 - Maintain `head`, `tail`, and `size` correctly across all operations.
 - After each edit, run `DoublyLinkedTransactionsTest` (or `./scripts/test-run.sh`).
*/

import main.java.com.wagmi.finance.model.Transaction;

public class DoublyLinkedTransactions {

    private static class Node {
        Transaction value;
        Node prev;
        Node next;

        Node(Transaction value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Transaction tx) {
        if(tx==null){
            return;
        
    }
        Node temp=new Node(tx);
        if(head==null){
            head=temp;
            tail=temp;
        }
        else{
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
            
        }
        size++;
  
    }

    public boolean deleteById(String id) {
        // stub: implement search and delete
        if (id == null || head == null) {
            return false;
        }

        Node current = head;
        while (current != null) {
            // Assuming Transaction.getId() is the correct way to get the ID
            if (current.value != null && id.equals(current.value.getId())) {
                
                // 1. Update the 'prev' node's 'next' pointer
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    // Node to delete is the head
                    head = current.next;
                }

                // 2. Update the 'next' node's 'prev' pointer
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    // Node to delete is the tail
                    tail = current.prev;
                }
                
                // Optional: Help Garbage Collector
                current.prev = null;
                current.next = null;

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    
    }

    public Transaction findById(String id) {
        // stub: linear search
        if(id==null || head==null){
            return null;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.value !=null){
                String curid=temp.value.getId();
                if(curid!=null && id.equals(curid)){
                    return temp.value;
                }
            }
            temp=temp.next;
        }
        return null;

    }

    public void reverse() {
        // stub: reverse pointers
        if (head == null || head == tail) {
            return; // 0 or 1 element list
        }

        Node current = head;
        Node temp = null;

        // Swap next and prev pointers for all nodes
        while (current != null) {
            temp = current.prev; // Store prev in temp
            current.prev = current.next; // Update prev to next
            current.next = temp;         // Update next to old prev (stored in temp)

            current = current.prev; // Move to the 'new' next node (which was the old prev)
        }
        
        // Swap head and tail pointers
        temp = head;
        head = tail;
        tail = temp;
        
    }

    public int size() {
        return size;
    }

    public Transaction[] toArray() {
        // stub: iterate from head
        public Transaction[] toArray() {
        Transaction[] arr=new Transaction[size];
        if(size==0){
            return arr;
        }
        Node temp=head;
        int i=0;
        while(temp!=null){
            arr[i]=temp.value;
            temp=temp.next;
            i++;
        }
        return arr;
        
    }
}
