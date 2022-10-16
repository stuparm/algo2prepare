package com.algo2prepare.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mihailo Stupar
 */
public class Graph {


    /**
     * Generates adjacency list for undirected graph
     * @param n number of nodes
     * @param edges matrix with n rows and two columns. Each row represents single edge [node1][node2]
     * @return array with length n. Where each element is List<Integer>
     */
    public static List<Integer>[] undirected(int n, int[][] edges) {

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] row : edges) {
            int v = row[0];
            int w = row[1];
            adj[v].add(w);
            adj[w].add(v);
        }

        return adj;
    }

    /**
     * Generates adjacency list for undirected graph
     * @param n number of nodes
     * @param text text representation of a matrix  with n rows and two columns. Each row represents single edge
     *             [node1][node2]. Example: n=4,  text="[[0,1],[0,2],[0,3],[1,3]]"
     * @return array with length n. Where each element is List<Integer>
     */
    public static List<Integer>[] undirected(int n, String text) {
        int[][] graph = Matrix.ints(text);
        return undirected(n, graph);
    }

    /**
     * Generates adjacency list for directed graph
     * @param n number of nodes
     * @param edges matrix with n rows and two columns. Each row represents single edge [node1][node2]
     * @return array with length n. Where each element is List<Integer>
     */
    public static List<Integer>[] directed(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] row : edges) {
            int v = row[0];
            int w = row[1];
            adj[v].add(w);
        }

        return adj;
    }

    /**
     * Generates adjacency list for directed graph
     * @param n number of nodes
     * @param text text representation of a matrix  with n rows and two columns. Each row represents single edge
     *             [node1][node2]. Example: n=4,  text="[[0,1],[0,2],[0,3],[1,3]]"
     * @return array with length n. Where each element is List<Integer>
     */
    public static List<Integer>[] directed(int n, String text) {
        int[][] edges = Matrix.ints(text);
        return directed(n, edges);
    }





}
