class LRUCache {

    private Map<Integer, Node> lruCache;
    private final Node head;
    private final Node tail;
    private final int capacity;

    class Node {

        private Node next;
        private Node prev;
        private int value;
        private int key;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lruCache = new HashMap<>();

        Node head = new Node(0,0);
        Node tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;

        this.head = head;
        this.tail = tail;

    }
    
    public int get(int key) {

        if (lruCache.containsKey(key)){

            Node node = lruCache.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;

        }

        return -1;
        
    }
    
    public void put(int key, int value) {

        Node toUpdate = null;

        if (lruCache.containsKey(key)){

            toUpdate = lruCache.get(key);
            toUpdate.value = value;
            removeNode(toUpdate);

        } else {

            toUpdate = new Node(key, value);
            lruCache.put(key, toUpdate);

            if (lruCache.size() > capacity){

                Node toRemove = tail.prev;
                removeNode(toRemove);
                lruCache.remove(toRemove.key);

            }

        }

        addToFront(toUpdate);
        
    }

    private void removeNode(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    
    private void addToFront(Node node){

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }
}
