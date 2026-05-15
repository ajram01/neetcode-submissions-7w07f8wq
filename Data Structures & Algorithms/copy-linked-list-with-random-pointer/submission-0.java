/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}am 
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node, Node> nodeMap = new HashMap<>();

        Node curr = head;

        while (curr != null ){

            Node currNode = new Node(curr.val);

            nodeMap.put(curr, currNode);

            curr = curr.next;
        }

        curr = head;

        while ( curr != null ){

            Node copy = nodeMap.get(curr);
            copy.next = nodeMap.get(curr.next);
            copy.random = nodeMap.get(curr.random);
            curr = curr.next;
        }

        return nodeMap.get(head);
        
    }
}
