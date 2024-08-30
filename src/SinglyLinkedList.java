import java.util.Scanner;

class Node{
    private int data;
    private Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }

    //Getter for data
    public int getData(){
        return data;
    }

    //setter for data
    public void setData(int data){
        this.data=data;
    }

    //Getter for next node
    public Node getNext(){
        return next;
    }

    //setter for next node
    public void setNext(Node next){
        this.next=next;
    }
}

public class SinglyLinkedList{
    private Node head;

    public SinglyLinkedList(){
        head=null;
    }

    //Method to insert a node at the beginning of the list
    public void insertAtBeginning(int data){
        Node newNode=new Node(data); //create a new node
        newNode.setNext(head);
        head=newNode;
    }

    //Method to insert a node at the end of the list
    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node temp=head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    //Method to insert a node after a given node
    public void insertAfter(Node prevNode,int data){
        if(prevNode==null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode=new Node(data);
        newNode.setNext(prevNode.getNext());
        prevNode.setNext(newNode);
    }

    //Method to delete the first node with a specified value- first occurrence
    public void deleteNode(int key){
        Node temp=head,prev=null;
        if(temp!=null && temp.getData()==key){
            head=temp.getNext();
            return;
        }

        while(temp!=null && temp.getData()!=key){
            prev=temp;
            temp=temp.getNext();
        }

        if(temp==null) return;  //Exit if the node with the key is not found

        prev.setNext(temp.getNext());
    }

    // Method to search for a node with a specified value
    public boolean search(int key){
        Node temp=head;
        while(temp!=null){
            if(temp.getData()==key) return true;
            temp=temp.getNext();
        }
        return false;
    }

    // Method to print all nodes in the list
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println();
    }

    //Main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SinglyLinkedList list=new SinglyLinkedList();
        while(true){
            System.out.println("Menu:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert a End");
            System.out.println("3. Insert after a Node");
            System.out.println("4. Delete a Node");
            System.out.println("5. Search for a node");
            System.out.println("6. Print List");
            System.out.println("7. Exit");

            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter value to insert at beginning: ");
                    int data1=sc.nextInt();
                    list.insertAtBeginning(data1);
                    break;
                case 2:
                    System.out.println("Enter value to insert at end: ");
                    int data2=sc.nextInt();
                    list.insertAtEnd(data2);
                    break;
                case 3:
                    System.out.println("Enter value to insert after: ");
                    int afterValue = sc.nextInt();
                    System.out.println("Enter new value to insert: ");
                    int newValue = sc.nextInt();

                    Node temp = list.head;
                    while (temp != null && temp.getData() != afterValue) {
                        temp = temp.getNext();
                    }

                    if (temp == null) {
                        System.out.println("Node with value " + afterValue + " not found in the list.");
                    } else {
                        list.insertAfter(temp, newValue);
                        System.out.println("Inserted " + newValue + " after " + afterValue + ".");
                    }
                    break;

                case 4:
                    System.out.println("Enter value to delete : ");
                    int deleteValue=sc.nextInt();
                    list.deleteNode(deleteValue);
                    break;

                case 5:
                    System.out.println("Enter value to search: ");
                    int searchValue=sc.nextInt();
                    boolean found=list.search(searchValue);
                    System.out.println("Search result: "+(found?"Found":"Not Found"));
                    break;

                case 6:
                    System.out.println("Linked List: ");
                    list.printList();
                    break;

                case 7:
                    sc.close();
                    System.out.println("Exiting...");
                    return;
                    
                default:
                    System.out.println("Invalid choice.Please try again.");
            }
        }
    }
}