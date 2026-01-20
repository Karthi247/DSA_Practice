package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTree {

    // ================= NODE CLASS =================
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root = null;

    // ================= INSERT (LEVEL ORDER) =================
    void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    // ================= INORDER =================
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // ================= PREORDER =================
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // ================= POSTORDER =================
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // ================= LEVEL ORDER =================
    void levelOrder() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    // ================= COUNT NODES =================
    int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // ================= COUNT LEAF NODES =================
    int countLeafNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // ================= HEIGHT =================
    int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // ================= SEARCH =================
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return search(root.left, key) || search(root.right, key);
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        int choice, data;

        do {
            System.out.println("\n===== BINARY TREE MENU =====");
            System.out.println("1. Insert");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Preorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Level Order Traversal");
            System.out.println("6. Count Total Nodes");
            System.out.println("7. Count Leaf Nodes");
            System.out.println("8. Height of Tree");
            System.out.println("9. Search Element");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    tree.insert(data);
                    break;

                case 2:
                    System.out.print("Inorder: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Preorder: ");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Postorder: ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Level Order: ");
                    tree.levelOrder();
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Total nodes: " + tree.countNodes(tree.root));
                    break;

                case 7:
                    System.out.println("Leaf nodes: " + tree.countLeafNodes(tree.root));
                    break;

                case 8:
                    System.out.println("Height of tree: " + tree.height(tree.root));
                    break;

                case 9:
                    System.out.print("Enter value to search: ");
                    data = sc.nextInt();
                    System.out.println(
                        tree.search(tree.root, data) ? "Element found" : "Element not found"
                    );
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
