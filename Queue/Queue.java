package Queue;
import java.util.Scanner;

class Queue {

    int[] queue;
    int front, rear, size;

    // ================= CONSTRUCTOR =================
    Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // ================= ENQUEUE =================
    void enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        queue[++rear] = data;
        System.out.println(data + " inserted into queue");
    }

    // ================= DEQUEUE =================
    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(queue[front] + " removed from queue");
        front++;
    }

    // ================= PEEK =================
    void peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element: " + queue[front]);
    }

    // ================= isEmpty =================
    boolean isEmpty() {
        return front == -1 || front > rear;
    }

    // ================= isFull =================
    boolean isFull() {
        return rear == size - 1;
    }

    // ================= DISPLAY =================
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        Queue q = new Queue(size);

        int choice, data;

        do {
            System.out.println("\n===== QUEUE MENU =====");
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
                    q.enqueue(data);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    System.out.println(q.isEmpty() ? "Queue is Empty" : "Queue is NOT Empty");
                    break;

                case 5:
                    System.out.println(q.isFull() ? "Queue is Full" : "Queue is NOT Full");
                    break;

                case 6:
                    q.display();
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
