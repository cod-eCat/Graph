package com.lpa.simplegraph;

import java.util.Stack;

public class DFS {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DFS(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w:G.adj(v)){
            if (!marked[w]){
                marked[w] = true;
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x!=s; x=edgeTo[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

}
