class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node left, right;
    int cap;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
        cache = new HashMap<>();
    }

    private void remove(Node node) {
        Node temp = node.next;
        node.next.prev = node.prev;
        node.prev.next = temp;
    }

    private void insert(Node node) {
        Node rightPrev = right.prev;
        node.prev = rightPrev;
        rightPrev.next = node;
        right.prev = node;
        node.next = right;
    }
    
    public int get(int key) {

        if(!cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if(cache.size() > cap) {
            Node rmNode = left.next;
            remove(rmNode);
            cache.remove(rmNode.key);
        }
        
    }
}
