package com.dnstth.vtmg.view;

/**
 * @author Denes_Toth
 */
public abstract class LightweightView {

    private int id;

    private String displayText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
