package org.example.tasks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    private Queue<Integer> queue;

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }


    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int[] BFS(int n) {


        boolean nodes[] = new boolean[V];
        int a = 0;

        int counter = 0;
        int[] result = new int[adj.length];
        int[] level = new int[adj.length];
        Arrays.fill(level, -1);
        level[n] = 0;


        nodes[n] = true;
        queue.add(n);

        while (queue.size() != 0) {
            n = queue.poll();

            result[counter++] = n;



            for (int i = 0; i < adj[n].size(); i++) {
                a = adj[n].get(i);
                if (!nodes[a]) {
                    nodes[a] = true;
                    level[a] = level[n] + 1;
                    queue.add(a);
                }
            }


        }

        return level;

    }


}

