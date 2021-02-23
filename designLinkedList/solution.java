class MyLinkedList {

    Node head;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
    
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>=size || index<0)
            return -1;
        
        Node current = head;
        int i=0;
        while(i<index)
        {
            current = current.next;
            i++;
        }
        
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        Node current = head;
        
        head = new Node(val);
        head.next = current;
        
        size++;
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        size++;
        Node newNode = new Node(val);
        if(head==null)
        {
            head = newNode;
        }
        else{
        Node current = head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next = newNode;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        if(index>size || index<0)
            return;
        if(index==0)
            addAtHead(val);
        else if(index==size)
            addAtTail(val);
        else{
            size++;
            int count = 0;
            Node current = head;
            Node prev = null;
            while(current!=null)
            {
                if(count==index)
                    break; 
                
                prev = current;
                current = current.next;
                count++;
            }
            Node newNode = new Node(val);
            prev.next = newNode;
            newNode.next = current;
            
        }
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=size || index<0)
            return;
        size--;
        if(index==0)
        {
            head = head.next;
            return;
        }
        if(size==0)
        {
            head=null;
            return;
        }
        Node current = head;
        for(int i=0; i<index-1; i++)
        {
            current=current.next;
        }
        current.next = current.next.next;
    }
    
    private class Node {
        int val;
        Node next;
        
        private Node(int val)
        {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */