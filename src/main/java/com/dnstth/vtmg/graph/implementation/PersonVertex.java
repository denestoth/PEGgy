package com.dnstth.vtmg.graph.implementation;

import com.dnstth.vtmg.dal.dto.Person;

/**
 * @author Denes_Toth
 */
public class PersonVertex extends DefaultVertex {

    Person person;

    public PersonVertex(Person person) {
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String getCaption() {
        return this.person.getName();
    }

    @Override
    public int hashCode() {
        return person.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return person.equals(obj);
    }
}
