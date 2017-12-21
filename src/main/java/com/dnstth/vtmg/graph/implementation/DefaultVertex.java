package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.graph.Edge;
import com.dnstth.vtmg.graph.Vertex;

/**
 * @author Denes_Toth
 */
public class DefaultVertex implements Vertex {

    private Edge edge1;

    private Edge edge2;

    public DefaultVertex(Edge edge1, Edge edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;
    }

    public Edge getEdge1() {
        return edge1;
    }

    public void setEdge1(Edge edge1) {
        this.edge1 = edge1;
    }

    public Edge getEdge2() {
        return edge2;
    }

    public void setEdge2(Edge edge2) {
        this.edge2 = edge2;
    }
}
