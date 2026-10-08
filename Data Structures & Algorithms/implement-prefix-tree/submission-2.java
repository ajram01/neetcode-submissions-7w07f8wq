class PrefixTree {

    private final Node sentinal;

    private class Node {

        private Map<Character, Node> children;
        private boolean isEnd;

        public Node(){

            this.children = new HashMap<>();

        }

        public boolean getIsEnd(){
            return isEnd;
        }

        public Node getChild(char character){

            return children.get(character);

        }

        public void addChild(char character, Node node){

            children.put(character, node);

        }

        public void setIsEnd(){
            this.isEnd = true;
        }

    }

    public PrefixTree() {
        
        this.sentinal = new Node();
         
    }

    public void insert(String word) {

        Node curr = sentinal;

        for (int i = 0; i < word.length(); i++){
            if (curr.getChild(word.charAt(i)) != null){
                curr = curr.getChild(word.charAt(i));
            } else {
                Node newNode = new Node();
                curr.addChild(word.charAt(i), newNode);
                curr = newNode;
            }
        }

        curr.setIsEnd();

    }

    public boolean search(String word) {

        Node curr = sentinal;

        for (int i = 0; i < word.length(); i++){

            curr = curr.getChild(word.charAt(i));

            if (curr == null){
                return false;
            }

        }

        return curr.getIsEnd();

    }

    public boolean startsWith(String prefix) {

        Node curr = sentinal;

        for (int i = 0; i < prefix.length(); i++){

            curr = curr.getChild(prefix.charAt(i));

            if (curr == null){
                return false;
            }

        }

        return true;

    }
}
