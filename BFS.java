package com.lpa.simplegraph;

import java.util.Stack;

public class BFS {

    private final int s;
    private boolean[] marked;
    private int[] edgeTo;

    public BFS(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int v){
        marked[v] = true;
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        while (!queue.isEmpty()){
            int r = queue.dequeue();
            for (int w:G.adj(r)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = r;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x=v; x!=s; x=edgeTo[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

}
