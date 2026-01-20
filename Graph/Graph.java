package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    // ================= CONSTRUCTOR =================
    Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // ================= ADD EDGE =================
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // undirected graph
    }

    // ================= DISPLAY GRAPH =================
    void display() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int node : adjList[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    // ================= BFS =================
    void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adj : adjList[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
        System.out.println();
    }

    // ================= DFS =================
    void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjList[vertex]) {
            if (!visited[adj]) {
                dfsUtil(adj, visited);
            }
        }
    }

    void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        Graph graph = new Graph(v);

        int choice, src, dest, start;

        do {
            System.out.println("\n===== GRAPH MENU =====");
            System.out.println("1. Add Edge");
            System.out.println("2. Display Graph");
            System.out.println("3. BFS Traversal");
            System.out.println("4. DFS Traversal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter source vertex: ");
                    src = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    dest = sc.nextInt();
                    graph.addEdge(src, dest);
                    break;

                case 2:
                    graph.display();
                    break;

                case 3:
                    System.out.print("Enter start vertex for BFS: ");
                    start = sc.nextInt();
                    graph.bfs(start);
                    break;

                case 4:
                    System.out.print("Enter start vertex for DFS: ");
                    start = sc.nextInt();
                    graph.dfs(start);
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
