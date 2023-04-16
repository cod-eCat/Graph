package com.lpa.simplegraph;

import java.util.Iterator;

public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i<V; i++){
            adj[i]=new Bag<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E+=1;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    @Override
    public String toString() {
        String s = V + " Vertices, " + E + " Edges\n";
        for (int v=0; v<V; v++){
            s+=v + " : ";
            for (int w:adj(v)){
                s+=w + " ";
            }
            s+="\n";
        }
        return s;
    }
}
