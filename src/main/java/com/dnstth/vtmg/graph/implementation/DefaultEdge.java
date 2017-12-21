package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.graph.Edge;

/**
 * @author Denes_Toth
 */
public class DefaultEdge implements Edge {

    private String caption;

    public DefaultEdge(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
