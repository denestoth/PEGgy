package com.dnstth.vtmg.graph.factory.implementation;

import com.dnstth.vtmg.dal.dto.Event;
import com.dnstth.vtmg.dal.dto.Person;
import com.dnstth.vtmg.dal.service.PersonService;
import com.dnstth.vtmg.graph.factory.GraphFactory;
import com.dnstth.vtmg.graph.implementation.DefaultEdge;
import com.dnstth.vtmg.graph.implementation.DefaultVertex;
import com.dnstth.vtmg.graph.implementation.EventVertex;
import com.dnstth.vtmg.graph.implementation.PersonAndEventGraph;
import com.dnstth.vtmg.graph.implementation.PersonVertex;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

/**
 * @author Denes_Toth
 */
@Component
public class PersonAndEventGraphFactory implements GraphFactory<Person> {

    private static int GRAPH_SVG_WIDTH = 5000;

    @Autowired
    private PersonService personService;

    @Override
    public String createFullGraph() {
        return createFilteredGraph(personService.findAll());
    }

    @Override
    public String createFilteredGraph(List<Person> filter) {
        PersonAndEventGraph personAndEventGraph = new PersonAndEventGraph();

        for (Person person : filter) {
            personAndEventGraph.addPersonVertex(new PersonVertex(person));
            addOrConnectEvents(personAndEventGraph, person);
        }

        return transform(personAndEventGraph);
    }

    private void addOrConnectEvents(PersonAndEventGraph personAndEventGraph, Person person) {
        for (Event event : person.getEvents()) {

            if (!personAndEventGraph.getEventVertices().stream().filter(v -> v.equals(event)).findFirst().isPresent()) {
                personAndEventGraph.addEventVertex(new EventVertex(event));
            }

            PersonVertex personVertexV = personAndEventGraph.getPersonVertices().stream().filter(v -> v.equals(person)).findFirst().get();
            EventVertex eventVertex = personAndEventGraph.getEventVertices().stream().filter(v -> v.equals(event)).findFirst().get();

            personAndEventGraph.addEdge(new DefaultEdge(personVertexV, eventVertex));
        }
    }

    private String transform(PersonAndEventGraph personAndEventGraph) {
        Map<DefaultVertex, Node> nodes = new HashMap<>();

        for (PersonVertex vertex : personAndEventGraph.getPersonVertices()) {
            nodes.put(vertex, node(vertex.getCaption()).with(Shape.CIRCLE));
        }

        for (EventVertex vertex : personAndEventGraph.getEventVertices()) {
            nodes.put(vertex, node(vertex.getCaption()).with(Shape.RECTANGLE));
        }

        for (DefaultEdge edge : personAndEventGraph.getEdges()) {
            nodes.put((DefaultVertex) edge.getVertex1(), nodes.get(edge.getVertex1()).link(nodes.get(edge.getVertex2())));
        }

        guru.nidi.graphviz.model.Graph graph = graph("");

        for (int i = 0; i < nodes.entrySet().size(); i++) {
            graph = graph.with(nodes.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList()).get(i));
        }

        return Graphviz.fromGraph(graph).width(GRAPH_SVG_WIDTH).render(Format.SVG).toString();
    }
}
