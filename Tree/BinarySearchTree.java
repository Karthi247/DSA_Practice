package Tree;

import java.util.Scanner;

class BinarySearchTree {

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

    // ================= INSERT =================
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    // ================= SEARCH =================
    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
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

    // ================= FIND MIN =================
    int findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    // ================= FIND MAX =================
    int findMax(Node root) {
        while (root.right != null)
            root = root.right;
        return root.data;
    }

    // ================= HEIGHT =================
    int height(Node root) {
        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // ================= COUNT NODES =================
    int countNodes(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // ================= COUNT LEAF NODES =================
    int countLeafNodes(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        int choice, data;

        do {
            System.out.println("\n===== BINARY SEARCH TREE MENU =====");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Find Minimum");
            System.out.println("7. Find Maximum");
            System.out.println("8. Height of Tree");
            System.out.println("9. Count Total Nodes");
            System.out.println("10. Count Leaf Nodes");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    bst.root = bst.insert(bst.root, data);
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    data = sc.nextInt();
                    System.out.println(
                        bst.search(bst.root, data) ? "Element found" : "Element not found"
                    );
                    break;

                case 3:
                    System.out.print("Inorder: ");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Preorder: ");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Postorder: ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;

                case 6:
                    if (bst.root != null)
                        System.out.println("Minimum value: " + bst.findMin(bst.root));
                    else
                        System.out.println("Tree is empty");
                    break;

                case 7:
                    if (bst.root != null)
                        System.out.println("Maximum value: " + bst.findMax(bst.root));
                    else
                        System.out.println("Tree is empty");
                    break;

                case 8:
                    System.out.println("Height of tree: " + bst.height(bst.root));
                    break;

                case 9:
                    System.out.println("Total nodes: " + bst.countNodes(bst.root));
                    break;

                case 10:
                    System.out.println("Leaf nodes: " + bst.countLeafNodes(bst.root));
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
