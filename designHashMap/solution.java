/**
 * Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */
class MyHashMap {

    Node[] nodes = new Node[10000];
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int hashVal = getHashValue(key);
        
        if(nodes[hashVal]==null)
            nodes[hashVal] = new Node(-1,-1);
        
        Node prev = getPrevElement(nodes[hashVal],key);
        
        if(prev.next==null)
            prev.next = new Node(key,value);
        
        else
            prev.next.val = value;
            
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int i = getHashValue(key);
            
        if(nodes[i]==null)
            return -1;
        
        Node temp = getPrevElement(nodes[i],key);
        
        if(temp.next==null)
            return -1;
        else 
            return temp.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = getHashValue(key);
        
        if(nodes[i]==null)
            return;
        
        Node last = getPrevElement(nodes[i],key);
        
        if(last.next==null)
            return;
        
        last.next = last.next.next;
    }
    
    private int getHashValue(int key)
    {
        return key%nodes.length;
    }
    
    private Node getPrevElement(Node node, int key)
    {
        Node temp = node;
        Node prev = null;
        
        while(temp!=null && temp.key!=key)
        {
            prev = temp;
            temp = temp.next;
            
        }
        
        return prev;
    }
    class Node{
        int key, val;
        Node next;
        
        Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */