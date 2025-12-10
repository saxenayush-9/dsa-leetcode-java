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
        if (head == null)
            return null;
        Node temp = head;

        //inserting duplicate node with next pointer
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        //setting random pointer
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        temp = head;
        Node dummy = new Node(-1);
        Node temp1 = dummy;

        //seperating both the lists
        while (temp != null) {
            temp1.next = temp.next;
            temp1 = temp1.next;
            temp.next = temp1.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}