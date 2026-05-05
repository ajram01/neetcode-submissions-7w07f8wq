class PrefixTree {

    Node root;

    class Node{

        HashMap<Character, Node> children;
        boolean isEnd;

        public Node(HashMap<Character, Node> children, boolean isEnd){
            this.children = children;
            this.isEnd = isEnd;
        }

    }

    public PrefixTree() {
        this.root = new Node(new HashMap<>(), false);
    }

    public void insert(String word) {

        Node currNode = root;

        for (char currChar : word.toCharArray()){
            if (!currNode.children.containsKey(currChar)){
                Node newNode = new Node(new HashMap<>(), false);
                currNode.children.put(currChar, newNode);
            }

            currNode = currNode.children.get(currChar);
        }

        currNode.isEnd = true;

    }

    public boolean search(String word) {

        Node currNode = root;

        for (char currChar : word.toCharArray()){
            if (!currNode.children.containsKey(currChar)){
                return false;
            }
            currNode = currNode.children.get(currChar);
        }

        return currNode.isEnd ? true : false;

    }

    public boolean startsWith(String prefix) {

        Node currNode = root;

        for (char currChar : prefix.toCharArray()){
            if (!currNode.children.containsKey(currChar)){
                return false;
            }
            currNode = currNode.children.get(currChar);
        }

        return true;


    }
}
