class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    HashMap<Integer,Node> hmap;

    List<Node> lru;
    int capacity = 0;

    Node head;
    Node tail;

    public void placeAtFront(Node node){
        Node prev = node.prev;
        Node next = node.next;

        if(prev!=null)prev.next = next;
        if(next!=null)next.prev = prev;

        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    public void removeFromBack(){
        Node node = tail.prev;
        hmap.remove(node.key);

        Node prev = node.prev;
        Node next = node.next;

        if(prev!=null)prev.next = next;
        if(next!=null)next.prev = prev;
    }

    public LRUCache(int capacity) {
        hmap=new HashMap<>();
        this.capacity=capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!hmap.containsKey(key))return -1;
        Node node = hmap.get(key);
        placeAtFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)){
           Node node = hmap.get(key);
           node.val = value;
           placeAtFront(node);
        }
        else{
            Node node = new Node(key,value);
            if(hmap.size()>=capacity){
                removeFromBack();
            }
            hmap.put(key,node);
            placeAtFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */