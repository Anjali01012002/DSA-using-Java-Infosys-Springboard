class Node{
    private int data;
    private Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList{
        private Node head;

        public LinkedList(){
            head=null;
        }

        //Add more to the end of the list
        public void add(int data){
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

        //Find position of a given element
        public int findPosition(int element){
            Node current=head;
            int position=1;

            while(current!=null){
                if(current.getData()==element){
                    return position;
                }
                current=current.getNext();
                position++;
            }
            return 0;
        }
}
public class FindPositionInLinkedList {
    public static void main(String[] agrs){
        LinkedList list=new LinkedList();
            list.add(10);
            list.add(15);
            list.add(16);
            list.add(20);
            list.add(30);
            list.add(40);

            int findElement=20;
            int position=list.findPosition(findElement);

            System.out.println("Position of "+findElement+": "+position);
    }
}
