import java.util.Scanner;

class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    // Insert a node at the beginning of the list
    public void insertAtBeginning(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
    }

    // Insert a node at the end of the list
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
        }
    }

    // Insert a node after a given node
    public void insertAfter(Node prevNode, String data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node newNode = new Node(data);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);

        if (prevNode == tail) {
            tail = newNode;
        }
    }

    // Delete a node with the given data
    public void deleteNode(String key) {
        if (head == null) {
            return;
        }

        Node current = head;
        Node prev = null;

        if (current.getData().equals(key)) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                tail.setNext(head);
            }
            return;
        }

        do {
            prev = current;
            current = current.getNext();
        } while (current != head && !current.getData().equals(key));

        if (current != head) {
            prev.setNext(current.getNext());
            if (current == tail) {
                tail = prev;
            }
        }
    }

    // Search for a node with the given data
    public boolean search(String key) {
        if (head == null) {
            return false;
        }

        Node temp = head;
        do {
            if (temp.getData().equals(key)) {
                return true;
            }
            temp = temp.getNext();
        } while (temp != head);
        return false;
    }

    // Print the circular linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        } while (temp != head);
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After a Node");
            System.out.println("4. Delete a Node");
            System.out.println("5. Search for a Node");
            System.out.println("6. Print List");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    String data1 = scanner.nextLine();
                    list.insertAtBeginning(data1);
                    break;

                case 2:
                    System.out.print("Enter value to insert at end: ");
                    String data2 = scanner.nextLine();
                    list.insertAtEnd(data2);
                    break;

                case 3:
                    System.out.print("Enter value to insert after: ");
                    String afterValue = scanner.nextLine();
                    System.out.print("Enter new value to insert: ");
                    String newValue = scanner.nextLine();
                    Node temp = list.head;

                    // Traverse the list to find the node after which to insert
                    boolean found = false;
                    do {
                        if (temp.getData().equals(afterValue)) {
                            list.insertAfter(temp, newValue);
                            found = true;
                            break;
                        }
                        temp = temp.getNext();
                    } while (temp != list.head);

                    if (!found) {
                        System.out.println("Node with value " + afterValue + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter value to delete: ");
                    String deleteValue = scanner.nextLine();
                    list.deleteNode(deleteValue);
                    break;

                case 5:
                    System.out.print("Enter value to search: ");
                    String searchValue = scanner.nextLine();
                    boolean foundNode = list.search(searchValue);
                    System.out.println("Search result: " + (foundNode ? "Found" : "Not Found"));
                    break;

                case 6:
                    System.out.println("Circular Linked List:");
                    list.printList();
                    break;

                case 7:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
