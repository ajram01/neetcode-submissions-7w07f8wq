class LRUCache {

    private Map<Integer, Node> lruCache;
    private int capacity;
    private Node head;
    private Node tail;

    private class Node {
        
        int value;
        int key;
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

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if (lruCache.containsKey(key)){

            Node toGet = lruCache.get(key);
            remove(toGet);
            toFront(toGet);
            return toGet.value;
        }
            
        return -1;
        
    }
    
    public void put(int key, int value) {

        if (lruCache.containsKey(key)){
            Node toGet = lruCache.get(key);
            toGet.value = value;
            remove(toGet);
            toFront(toGet);
        } else {
            Node newNode = new Node(key, value);
            lruCache.put(key, newNode);
            toFront(newNode);
            if (lruCache.size() > capacity){

                Node toRemove = tail.prev;
                remove(toRemove);
                lruCache.remove(toRemove.key);
            }
        }
        
    }

    private void remove(Node node){

        Node prev = node.prev;
        node.next.prev = prev;
        node.prev.next = node.next;

    }

    private void toFront(Node node){

        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
}
