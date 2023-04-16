package com.lpa.simplegraph;

public class TestGraph {

    public static void main(String[] args) {

        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);

        System.out.println(graph.V());
        System.out.println(graph.E());

        System.out.println("Adjacent To 11");

        for (int w : graph.adj(0)) {
            System.out.print(" " + w + " ");
        }
        System.out.println();
        System.out.println("DFS");
        DFS dfs = new DFS(graph, 0);
        System.out.println(dfs.hasPathTo(11));
        for (int w : dfs.pathTo(5)) {
            System.out.print(" " + w + " ");
        }

        System.out.println();
        System.out.println("BFS");
        BFS bfs = new BFS(graph, 0);
        System.out.println(bfs.hasPathTo(11));
        for (int w : bfs.pathTo(5)) {
            System.out.print(" " + w + " ");
        }

    }


}
