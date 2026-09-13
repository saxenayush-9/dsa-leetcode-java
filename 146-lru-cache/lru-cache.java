class LRUCache {

    class LRUNode{
        int key;
        int val;
        LRUNode prev;
        LRUNode next;
        LRUNode(int key, int val){
            this.key=key;
            this.val=val;
        }
    }

    int capacity;
    int size = 0;
    LRUNode head;
    LRUNode tail;

    HashMap<Integer,LRUNode> hmap;

    public void removeLast(){
        LRUNode last = tail.prev;
        last.prev.next=tail;
        tail.prev=last.prev;
        hmap.remove(last.key);
    }

    public void moveForward(LRUNode n){
        if(n.prev!=null)n.prev.next=n.next;
        if(n.next!=null)n.next.prev=n.prev;

        n.next=head.next;
        head.next.prev=n;
        head.next=n;
        n.prev=head;
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new LRUNode(-1,-1);
        tail=new LRUNode(-1,-1);
        hmap = new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)){
            LRUNode node = hmap.get(key);
            moveForward(node);
            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key)){
            LRUNode node = hmap.get(key);
            node.val=value;
            moveForward(node);
            return;
        }
        if(size>=capacity){
            removeLast();
            size--;
        }
        LRUNode newNode = new LRUNode(key,value);
        moveForward(newNode);
        hmap.put(key,newNode);
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */