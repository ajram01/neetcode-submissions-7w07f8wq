class LRUCache {

    private Map<Integer, Node> lruCache;
    private int capacity;
    private Node head;
    private Node tail;


    private class Node {
        
        private Node prev;
        private Node next;
        private int val;
        private int key;

        public Node (int key, int val){

            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;

        }

    }

    public LRUCache(int capacity) {

        lruCache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {

        if (!lruCache.containsKey(key)){
            return -1;
        }

        Node getNode = lruCache.get(key);
        removeNode(getNode);
        moveToFront(getNode);
        return getNode.val;
        
    }
    
    public void put(int key, int value) {

        if (lruCache.containsKey(key)){
            Node curr = lruCache.get(key);
            curr.val = value;
            removeNode(curr);
            moveToFront(curr);

        } else {

            Node newNode = new Node(key, value);
            moveToFront(newNode);
            lruCache.put(key, newNode);

        }

        if (lruCache.size() > capacity){

            Node lru = tail.prev;
            removeNode(lru);
            lruCache.remove(lru.key);

        }
        
    }

    private void removeNode(Node node){

        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;

    }

    private void moveToFront(Node node){

        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

    }
}
