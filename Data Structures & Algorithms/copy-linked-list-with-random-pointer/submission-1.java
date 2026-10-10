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
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        HashMap<Node, Node> created = new HashMap<>();
        Node curr = head;

        while (curr != null){

            Node newNode = new Node(curr.val);
            created.put(curr, newNode);

            curr = curr.next;

        }

        curr = head;

        while (curr != null){

            Node createdNode = created.get(curr);
            createdNode.next = created.get(curr.next);
            createdNode.random = created.get(curr.random);

            curr = curr.next;

        }

        return created.get(head);
        
    }
}
