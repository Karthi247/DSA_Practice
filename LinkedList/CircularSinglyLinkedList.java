import java.util.Scanner;

class CircularSinglyLinkedList {

    // ================= NODE CLASS =================
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // ================= INSERT OPERATIONS =================

    // Insert at Beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at End
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at Position (1-based)
    void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ================= DELETE OPERATIONS =================

    // Delete from Beginning
    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        head = head.next;
        temp.next = head;
    }

    // Delete from End
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }

        temp.next = head;
    }

    // Delete by Value
    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head, prev = null;

        do {
            if (curr.data == value) {
                if (curr == head) {
                    deleteFromBeginning();
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Value not found");
    }

    // ================= SEARCH =================
    boolean search(int key) {
        if (head == null) return false;

        Node temp = head;
        do {
            if (temp.data == key)
                return true;
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    // ================= LENGTH =================
    int length() {
        if (head == null) return 0;

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // ================= DISPLAY =================
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        int choice, data, position;

        do {
            System.out.println("\n===== CIRCULAR SINGLY LINKED LIST MENU =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete by Value");
            System.out.println("7. Search");
            System.out.println("8. Length");
            System.out.println("9. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.insertAtPosition(data, position);
                    break;

                case 4:
                    list.deleteFromBeginning();
                    break;

                case 5:
                    list.deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter value to delete: ");
                    data = sc.nextInt();
                    list.deleteByValue(data);
                    break;

                case 7:
                    System.out.print("Enter value to search: ");
                    data = sc.nextInt();
                    System.out.println(list.search(data) ? "Element found" : "Element not found");
                    break;

                case 8:
                    System.out.println("Length of list: " + list.length());
                    break;

                case 9:
                    list.display();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
