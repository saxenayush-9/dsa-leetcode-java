class LRUCache {
    int val;
    int key;
    LRUCache prev;
    LRUCache next;
    int n;
    int count = 0;
    HashMap<Integer, LRUCache> hmap;
    LRUCache head;
    LRUCache tail;

    public LRUCache(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public LRUCache(int capacity) {
        this.n = capacity;
        hmap = new HashMap<>();
        head = new LRUCache(-1, -1);
        tail = new LRUCache(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hmap.containsKey(key)) {
            return -1;
        } else {
            LRUCache node = hmap.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            node.next = tail;
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (hmap.containsKey(key)) {
            LRUCache node = hmap.get(key);
            node.val = value;
            hmap.put(key, node);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            node.next = tail;
        } else {
            if (count == n) {
                LRUCache nodeToRemove = head.next;
                nodeToRemove.prev.next = nodeToRemove.next;
                nodeToRemove.next.prev = nodeToRemove.prev;
                hmap.remove(nodeToRemove.key);
                count--;
            }
            LRUCache node = new LRUCache(key, value);
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            node.next = tail;
            count++;
            hmap.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */