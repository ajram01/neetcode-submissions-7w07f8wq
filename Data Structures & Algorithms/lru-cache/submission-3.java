class LRUCache {

    private Map<Integer, Node> lruCache;
    private int capacity;
    private Node head;
    private Node tail;
    

    private class Node {

        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){

            this.key = key;
            this.value = value;

        }

    }

    public LRUCache(int capacity) {

        this.capacity = capacity;
        lruCache = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if (lruCache.containsKey(key)){

            Node toGet = lruCache.get(key);
            removeNode(toGet);
            moveToFront(toGet);
            
            return toGet.value;

        }
        
        return -1;
    }
    
    public void put(int key, int value) {

        if (lruCache.containsKey(key)){

            Node curr = lruCache.get(key);
            curr.value = value;
            removeNode(curr);
            moveToFront(curr);

        } else {

            Node newNode = new Node(key, value);
            lruCache.put(key, newNode);
            moveToFront(newNode);

            if (lruCache.size() > capacity){
                Node toRemove = tail.prev;
                removeNode(toRemove);
                lruCache.remove(toRemove.key);
            }

        }
        
    }

    private void removeNode(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void moveToFront(Node node){

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;

    }
}
