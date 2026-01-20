import java.util.Scanner;

class CircularDoublyLinkedList {

    // ================= NODE CLASS =================
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = this;
            this.next = this;
        }
    }

    Node head = null;

    // ================= INSERT OPERATIONS =================

    // Insert at Beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        head.prev = newNode;
        last.next = newNode;

        head = newNode;
    }

    // Insert at End
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;
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

        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
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

        Node last = head.prev;
        head = head.next;

        head.prev = last;
        last.next = head;
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

        Node last = head.prev;
        Node newLast = last.prev;

        newLast.next = head;
        head.prev = newLast;
    }

    // Delete by Value
    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            if (temp.data == value) {

                if (temp.next == temp) {
                    head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;

                    if (temp == head) {
                        head = temp.next;
                    }
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);

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

    // Forward
    void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    // Backward
    void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head.prev;
        Node last = temp;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != last);

        System.out.println("(back to tail)");
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        Scanner sc = new Scanner(System.in);

        int choice, data, position;

        do {
            System.out.println("\n===== CIRCULAR DOUBLY LINKED LIST MENU =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete by Value");
            System.out.println("7. Search");
            System.out.println("8. Length");
            System.out.println("9. Display Forward");
            System.out.println("10. Display Backward");
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
                    list.displayForward();
                    break;

                case 10:
                    list.displayBackward();
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
