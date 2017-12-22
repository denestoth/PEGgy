package com.dnstth.vtmg.graph;

import com.dnstth.vtmg.dal.dto.Event;
import com.dnstth.vtmg.dal.dto.Person;
import com.dnstth.vtmg.dal.service.EventService;
import com.dnstth.vtmg.dal.service.PersonService;
import com.dnstth.vtmg.graph.implementation.DefaultEdge;
import com.dnstth.vtmg.graph.implementation.DefaultVertex;
import com.dnstth.vtmg.graph.implementation.EventVertex;
import com.dnstth.vtmg.graph.implementation.PersonAndEventGraph;
import com.dnstth.vtmg.graph.implementation.PersonVertex;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

/**
 * @author Denes_Toth
 */
@Component
public class SomeGraphCreator {

    @Autowired
    private PersonService personService;
    @Autowired
    private EventService eventService;

    public Graph doSomeGraph() {
        PersonAndEventGraph g = new PersonAndEventGraph();

        for (Person p : personService.findAll()) {
            g.addPersonVertex(new PersonVertex(p));
            addOrConnectEvents(g, p);
        }

        transform(g);

        return g;
    }

    private void addOrConnectEvents(PersonAndEventGraph g, Person p) {
        for (Event event : p.getEvents()) {

            if (!g.getEventVertices().stream().filter(v -> v.equals(event)).findFirst().isPresent()) {
                g.addEventVertex(new EventVertex(event));
            }

            PersonVertex pV = g.getPersonVertices().stream().filter(v -> v.equals(p)).findFirst().get();
            EventVertex eV = g.getEventVertices().stream().filter(v -> v.equals(event)).findFirst().get();

            g.addEdge(new DefaultEdge(pV, eV));
        }
    }

    private void transform(PersonAndEventGraph paeg) {
        Map<DefaultVertex, Node> nodes = new HashMap<>();

        for (PersonVertex vertex : paeg.getPersonVertices()) {
            nodes.put(vertex, node(vertex.getCaption()));
        }

        for (EventVertex vertex : paeg.getEventVertices()) {
            nodes.put(vertex, node(vertex.getCaption()));
        }

        for (DefaultEdge edge : paeg.getEdges()) {
            nodes.put((DefaultVertex) edge.getVertex1(), nodes.get(edge.getVertex1()).link(nodes.get(edge.getVertex2())));
        }

        guru.nidi.graphviz.model.Graph g = graph("");

        for (int i = 0; i < nodes.entrySet().size(); i++) {
            g = g.with(nodes.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList()).get(i));
        }

        try {
            Graphviz.fromGraph(g).width(500).render(Format.PNG).toFile(new File("c:\\tmp\\x.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
