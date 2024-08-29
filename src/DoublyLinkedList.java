import java.util.Scanner;

class Node{
    private int data;
    private Node next;
    private Node prev;

    public Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next=next;
    }
    public Node getPrev(){
        return prev;
    }

    public void setPrev(Node prev){
        this.prev=prev;
    }
}

public class DoublyLinkedList{
    private Node head;

    public DoublyLinkedList(){
        head=null;
    }

    //Insert a new node at the beginning of the list
    public void insertBeginning(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            newNode.setNext(head);
            head.setPrev(newNode);
            head=newNode;
        }
    }

    //Insert a new node at the end of the list
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
            newNode.setPrev(temp);

        }
    }

    //Insert a new node after a given node
    public void insertAfter(Node prevNode, int data){
        if(prevNode==null){
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node newNode=new Node(data);
        newNode.setNext(prevNode.getNext());
        newNode.setPrev(prevNode);

        if(prevNode.getNext()!=null){
            prevNode.getNext().setPrev(newNode);
        }
        prevNode.setNext(newNode);
    }

    //Delete a node by its value
    public void deleteNode(int key){
        Node temp=head;

        if(temp!=null&&temp.getData()==key){
            head=temp.getNext();
            if(head!=null){
                head.setPrev(null);
            }
            return;
        }
    

        //Search for the node with the key to be deleted
        while(temp!=null&&temp.getData()!=key){
            temp=temp.getNext();
        }
        if(temp==null) return;

        if(temp.getPrev()!=null){
            temp.getPrev().setNext(temp.getNext());
        }

        if(temp.getNext()!=null){
            temp.getNext().setPrev(temp.getPrev());
        }
    }

    //Search for a node by its value
    public boolean search(int key){
        Node temp=head;
        while(temp!=null){
            if(temp.getData()==key) return true;
            temp=temp.getNext();
        }
        return false;
    }

    //Print the list in forward direction
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.getData()+" ");
            temp=temp.getNext();
        }
        System.out.println();
    }

    //print the list in reverse direction
    public void printListInReverse(){
        Node temp=head;
        if (temp == null) {
        System.out.println("The list is empty.");
        return;
        }
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }

        System.out.println("Reverse Traversal:");
        while(temp!=null){
            System.out.print(temp.getData()+" ");
            temp=temp.getPrev();
        }
        System.out.println();
    }

    //Main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        DoublyLinkedList list=new DoublyLinkedList();

        while(true){
            System.out.println("Menu: ");
            System.out.println("1. Insert at Beginning: ");
            System.out.println("2. Insert at End: ");
            System.out.println("3. Insert after a Node: ");
            System.out.println("4. Delete a Node: ");
            System.out.println("5. Search for a Node: ");
            System.out.println("6. Print List: ");
            System.out.println("7. Print List in Reverse: ");
            System.out.println("8. Exit: ");

            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    int data1=sc.nextInt();
                    list.insertBeginning(data1);
                    break;
                case 2:
                    System.out.print("Enter value to insert at End: ");
                    int data2=sc.nextInt();
                    list.insertAtEnd(data2);
                    break;
                case 3:
                    System.out.print("Enter value to insert after: ");
                    int afterValue=sc.nextInt();
                    System.out.print("Enter new value to insert: ");
                    int newValue=sc.nextInt();
                    Node temp=list.head;
                    while(temp!=null && temp.getData()!=afterValue){
                        temp=temp.getNext();
                    }
                    list.insertAfter(temp,newValue);
                    break;
                case 4:
                    System.out.print("Enter value to delete: ");
                    int deleteValue=sc.nextInt();
                    list.deleteNode(deleteValue);
                    break;
                case 5:
                    System.out.print("Enter value to search: ");
                    int searchValue=sc.nextInt();
                    boolean found=list.search(searchValue);
                    System.out.println("Search result: " + (found ? "Found" : "Not Found"));
                    break;
                case 6:
                    System.out.println("Doubly Linked List:");
                    list.printList();
                    break;
                case 7:
                    System.out.println("Doubly Linked List in Reverse:");
                    list.printListInReverse();
                    break;
                case 8:
                    sc.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.print("Invalid choice. Please try again.");

            }
        }
    }
}