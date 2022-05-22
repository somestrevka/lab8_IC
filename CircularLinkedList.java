/**
 * Implements a circular linked list
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     *
     * @param value
     * creates a node with the given value
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     *
     * @param currentNode
     * @return
     * returns the next node if it exists and null otherwise
     */
    public Node getNextNode(Node currentNode) {
        if (currentNode == null || currentNode.nextNode == null) {
            return null;
        }
        return currentNode.nextNode;
    }

    /**
     *
     * @param searchValue
     * @return
     * searches for the given value in the list
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     *
     * @param valueToDelete
     * removes a node from the list
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

}