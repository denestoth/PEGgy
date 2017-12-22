package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.graph.Edge;
import com.dnstth.vtmg.graph.Vertex;

/**
 * @author Denes_Toth
 */
public class DefaultEdge implements Edge {

    Vertex vertex1;
    Vertex vertex2;

    public DefaultEdge(Vertex vertex1, Vertex vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }
}
