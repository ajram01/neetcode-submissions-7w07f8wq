/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) return null;
        
        HashMap<Node, Node> cloned = new HashMap<>();
        return dfs(node, cloned);
    
    }

    public Node dfs(Node currNode, HashMap<Node, Node> cloned){

        if (cloned.containsKey(currNode)) return cloned.get(currNode);

        Node clonedNode = new Node(currNode.val);

        cloned.put(currNode, clonedNode);

        for (int i = 0; i < currNode.neighbors.size(); i++){
            
            Node neighbor = currNode.neighbors.get(i);
            Node clonedNeighbor = dfs(neighbor, cloned);
            clonedNode.neighbors.add(clonedNeighbor);
        }

        return clonedNode;

    }
}