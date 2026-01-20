package Queue;

import java.util.Scanner;

class CircularQueue {

    int[] queue;
    int front, rear, size;

    // ================= CONSTRUCTOR =================
    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // ================= isFull =================
    boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear + 1 == front);
    }

    // ================= isEmpty =================
    boolean isEmpty() {
        return front == -1;
    }

    // ================= ENQUEUE =================
    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Circular Queue Overflow");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = data;
        System.out.println(data + " inserted into circular queue");
    }

    // ================= DEQUEUE =================
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue Underflow");
            return;
        }

        System.out.println(queue[front] + " removed from circular queue");

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // ================= PEEK =================
    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element: " + queue[front]);
    }

    // ================= DISPLAY =================
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Circular Queue elements: ");

        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter circular queue size: ");
        int size = sc.nextInt();

        CircularQueue cq = new CircularQueue(size);

        int choice, data;

        do {
            System.out.println("\n===== CIRCULAR QUEUE MENU =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. isEmpty");
            System.out.println("5. isFull");
            System.out.println("6. Display");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    cq.enqueue(data);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.peek();
                    break;

                case 4:
                    System.out.println(cq.isEmpty() ? "Queue is Empty" : "Queue is NOT Empty");
                    break;

                case 5:
                    System.out.println(cq.isFull() ? "Queue is Full" : "Queue is NOT Full");
                    break;

                case 6:
                    cq.display();
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
