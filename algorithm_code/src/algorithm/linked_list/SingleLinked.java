package algorithm.linked_list;

// Singly Linked List Class
// Define the Node class
class Node {
    int data;
    Node next;


    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

// Define a LinkedList class to encapsulate operations
public class SingleLinked {
    // Function to traverse and print the elements of the
// linked list
    public static void traverseLinkedList(Node head)
    {
// Start from the head of the linked list
        Node current = head;

        // Traverse the linked list until reaching the end
        // (null)
        while (current != null) {
            // Print the data of the current node
            System.out.print(current.data + " ");

            // Move to the next node
            current = current.next;
        }

        System.out.println();
    }


    // Main method for example usage
    public static void main(String[] args)
    {
        // Create nodes
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        // Connect nodes
        head.next = second;
        second.next = third;

        // Call the traverseLinkedList function to print the
        // linked list elements
        traverseLinkedList(head);
    }
}