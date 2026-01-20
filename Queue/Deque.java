package Queue;  

import java.util.Scanner;

class Deque {

    int[] deque;
    int front, rear, size;

    // ================= CONSTRUCTOR =================
    Deque(int size) {
        this.size = size;
        deque = new int[size];
        front = -1;
        rear = -1;
    }

    // ================= isFull =================
    boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    // ================= isEmpty =================
    boolean isEmpty() {
        return front == -1;
    }

    // ================= INSERT FRONT =================
    void insertFront(int data) {
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }

        deque[front] = data;
        System.out.println(data + " inserted at front");
    }

    // ================= INSERT REAR =================
    void insertRear(int data) {
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }

        deque[rear] = data;
        System.out.println(data + " inserted at rear");
    }

    // ================= DELETE FRONT =================
    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return;
        }

        System.out.println(deque[front] + " removed from front");

        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    // ================= DELETE REAR =================
    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return;
        }

        System.out.println(deque[rear] + " removed from rear");

        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
    }

    // ================= PEEK FRONT =================
    void peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.println("Front element: " + deque[front]);
    }

    // ================= PEEK REAR =================
    void peekRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.println("Rear element: " + deque[rear]);
    }

    // ================= DISPLAY =================
    void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.print("Deque elements: ");
        int i = front;
        while (true) {
            System.out.print(deque[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter deque size: ");
        int size = sc.nextInt();

        Deque dq = new Deque(size);
        int choice, data;

        do {
            System.out.println("\n===== DEQUE MENU =====");
            System.out.println("1. Insert Front");
            System.out.println("2. Insert Rear");
            System.out.println("3. Delete Front");
            System.out.println("4. Delete Rear");
            System.out.println("5. Peek Front");
            System.out.println("6. Peek Rear");
            System.out.println("7. isEmpty");
            System.out.println("8. isFull");
            System.out.println("9. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    dq.insertFront(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    dq.insertRear(data);
                    break;

                case 3:
                    dq.deleteFront();
                    break;

                case 4:
                    dq.deleteRear();
                    break;

                case 5:
                    dq.peekFront();
                    break;

                case 6:
                    dq.peekRear();
                    break;

                case 7:
                    System.out.println(dq.isEmpty() ? "Deque is Empty" : "Deque is NOT Empty");
                    break;

                case 8:
                    System.out.println(dq.isFull() ? "Deque is Full" : "Deque is NOT Full");
                    break;

                case 9:
                    dq.display();
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
