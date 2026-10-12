class LRUCache {

    private Map<Integer, Node> lruCache;
    private int capacity;
    private Node head;
    private Node tail;

    private static class Node {

        private Node prev;
        private Node next;
        private int value;
        private int key;

        public Node (int key, int value){

            this.key = key;
            this.value = value;

        }

    }

    public LRUCache(int capacity) {

        this.capacity = capacity;
        lruCache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {

        Node getNode = lruCache.get(key);

        if (getNode == null){

            return -1;

        }

        removeNode(getNode);
        addToFront(getNode);

        return getNode.value;
        
    }
    
    public void put(int key, int value) {

        Node getNode = lruCache.get(key);

        if (getNode == null){

            getNode = new Node(key, value);
            lruCache.put(key, getNode);

        } else {

            getNode.value = value;
            removeNode(getNode);

        }

        if (lruCache.size() > capacity){

            Node toRemove = tail.prev;
            removeNode(toRemove);
            lruCache.remove(toRemove.key);

        }
        
        addToFront(getNode);

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
