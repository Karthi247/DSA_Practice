package Stack;

import java.util.Scanner;

class Stack {

    int[] stack;
    int top;
    int size;

    // ================= CONSTRUCTOR =================
    Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // ================= PUSH =================
    void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = data;
        System.out.println(data + " pushed into stack");
    }

    // ================= POP =================
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println(stack[top--] + " popped from stack");
    }

    // ================= PEEK =================
    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Top element: " + stack[top]);
    }

    // ================= isEmpty =================
    boolean isEmpty() {
        return top == -1;
    }

    // ================= isFull =================
    boolean isFull() {
        return top == size - 1;
    }

    // ================= DISPLAY =================
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        Stack s = new Stack(size);

        int choice, data;

        do {
            System.out.println("\n===== STACK MENU =====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
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
                    s.push(data);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.peek();
                    break;

                case 4:
                    System.out.println(s.isEmpty() ? "Stack is Empty" : "Stack is NOT Empty");
                    break;

                case 5:
                    System.out.println(s.isFull() ? "Stack is Full" : "Stack is NOT Full");
                    break;

                case 6:
                    s.display();
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
