package Stack;

import java.util.Stack;
import java.util.Scanner;

class ExpressionStackOperations {

    // ================= PRECEDENCE =================
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // ================= INFIX → POSTFIX =================
    static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            // '('
            else if (ch == '(') {
                stack.push(ch);
            }
            // ')'
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            // Operator
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // ================= INFIX → PREFIX =================
    static String infixToPrefix(String infix) {
        StringBuilder input = new StringBuilder(infix);
        input.reverse();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                input.setCharAt(i, ')');
            else if (input.charAt(i) == ')')
                input.setCharAt(i, '(');
        }

        String postfix = infixToPostfix(input.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    // ================= POSTFIX EVALUATION =================
    static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    // ================= PREFIX EVALUATION =================
    static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();

                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STACK EXPRESSION MENU =====");
            System.out.println("1. Infix to Postfix");
            System.out.println("2. Infix to Prefix");
            System.out.println("3. Evaluate Postfix");
            System.out.println("4. Evaluate Prefix");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter infix expression: ");
                    String infix1 = sc.nextLine();
                    System.out.println("Postfix: " + infixToPostfix(infix1));
                    break;

                case 2:
                    System.out.print("Enter infix expression: ");
                    String infix2 = sc.nextLine();
                    System.out.println("Prefix: " + infixToPrefix(infix2));
                    break;

                case 3:
                    System.out.print("Enter postfix expression (digits only): ");
                    String postfix = sc.nextLine();
                    System.out.println("Result: " + evaluatePostfix(postfix));
                    break;

                case 4:
                    System.out.print("Enter prefix expression (digits only): ");
                    String prefix = sc.nextLine();
                    System.out.println("Result: " + evaluatePrefix(prefix));
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
