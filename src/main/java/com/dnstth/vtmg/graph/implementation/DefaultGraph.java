package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.graph.Edge;
import com.dnstth.vtmg.graph.Graph;
import com.dnstth.vtmg.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denes_Toth
 */
public class DefaultGraph implements Graph {

    private List<Edge> edges;

    private List<Vertex> vertices;

    public DefaultGraph() {
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    public DefaultGraph(List<Edge> edges, List<Vertex> vertices) {
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

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }
}
