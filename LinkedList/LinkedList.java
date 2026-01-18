class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    Node head = null;

    public void add (int data){
        Node newNode = new Node(data);
        
        Node current = head;
        
        if(head==null){ 
            head = newNode;
        }
        else{
            while(current.next!=null){
                current = current.next;
            }
            current.next=newNode;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    public void delete(int data){
        if (head == null) { 
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        while(current.next!=null && current.next.data!=data){
            current = current.next;
        }
        if(current.next!=null){
            current.next = current.next.next;
        }
        PrintValues();
        if (current.next==null){
            System.out.println("Data is Not Presented");
        }
    }

    public void delPos(int pos){
        if (head == null) { 
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        Node Previous = null;

        if(pos==0){
            head = head.next;
        }

        for (int i=1;i<=pos;i++){
            Previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position " + pos + " does not exist!");
            return;
        }
        Previous.next = current.next;
    }

    public void addPos(int pos, int data){
        Node current = head;
        if (pos==0){
            add(data);
            return;
        }
        Node newNode = new Node(data);
        for(int i=1;i<pos;i++){
            current = current.next;
            if(current==null){
                System.out.println("Invalid");
            }
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void PrintValues (){
        Node current = head;

        if (head == null){
            System.out.println("LinkedList is Empty");
        }
        while(current!=null){
            System.out.print(current.data +" ");
            current = current.next;
        }
        System.out.println();
    }
}


//get(index)
//update(index)
//deleteAtEnd
//search(val) return index
//contains(val) return true or false