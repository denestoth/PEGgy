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

    public PersonAndEventGraph(List<PersonVertex> personVertices, List<EventVertex> eventVertices, List<DefaultEdge> edges) {
        this.personVertices = personVertices;
        this.eventVertices = eventVertices;
        this.edges = edges;
    }

    public List<PersonVertex> getPersonVertices() {
        return personVertices;
    }

    public void setPersonVertices(List<PersonVertex> personVertices) {
        this.personVertices = personVertices;
    }

    public List<EventVertex> getEventVertices() {
        return eventVertices;
    }

    public void setEventVertices(List<EventVertex> eventVertices) {
        this.eventVertices = eventVertices;
    }

    public List<DefaultEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<DefaultEdge> edges) {
        this.edges = edges;
    }

    public void addPersonVertices() {
        addPersonVertices();
    }

    public void addPersonVertex(PersonVertex personVertex) {
        personVertices.add(personVertex);
    }

    public void addPersonVertices(List<PersonVertex> personVertices) {
        personVertices.addAll(personVertices);
    }

    public void addEventVertex(EventVertex eventVertex) {
        eventVertices.add(eventVertex);
    }

    public void addEventVertices(List<EventVertex> eventVertices) {
        eventVertices.addAll(eventVertices);
    }

    public void addEdge(DefaultEdge edge) {
        edges.add(edge);
    }

    public void addEdges(List<DefaultEdge> edges) {
        edges.addAll(edges);
    }
}
