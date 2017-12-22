package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denes_Toth
 */
public class PersonAndEventGraph implements Graph {

    List<PersonVertex> personVertices;
    List<EventVertex> eventVertices;
    List<DefaultEdge> edges;

    public PersonAndEventGraph() {
        this.personVertices = new ArrayList<>();
        this.eventVertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public List<PersonVertex> getPersonVertices() {
        return personVertices;
    }

    public List<EventVertex> getEventVertices() {
        return eventVertices;
    }

    public List<DefaultEdge> getEdges() {
        return edges;
    }

    public void addPersonVertex(PersonVertex personVertex) {
        personVertices.add(personVertex);
    }

    public void addEventVertex(EventVertex eventVertex) {
        eventVertices.add(eventVertex);
    }

    public void addEdge(DefaultEdge edge) {
        edges.add(edge);
    }
}
