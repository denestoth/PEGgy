package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.graph.Edge;
import com.dnstth.vtmg.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denes_Toth
 */
public class DefaultGraph implements Graph {

    private List<Edge> edges;

    private List<Object> vertices;

    public DefaultGraph() {
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    public DefaultGraph(List<Edge> edges, List<Object> vertices) {
        this.edges = edges;
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public void addEdges(List<Edge> edges) {
        edges.addAll(edges);
    }

    public List<Object> getVertices() {
        return vertices;
    }

    public void setVertices(List<Object> vertices) {
        this.vertices = vertices;
    }

    public void addVertex(Object vertex) {
        vertices.add(vertex);
    }

    public void addVertices(List<Object> vertices) {
        vertices.addAll(vertices);
    }
}
