package com.dnstth.vtmg.graph.factory;

import java.util.List;

/**
 * @author Denes_Toth
 */
public interface GraphFactory<T> {

    String createFullGraph();

    String createFilteredGraph(List<T> filter);
}
