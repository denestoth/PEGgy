package com.dnstth.vtmg.facade;

import com.dnstth.vtmg.view.PersonView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PersonFacade {

    List<PersonView> getAll();

    PersonView getOne(int id);

    void add(PersonView personView);

    void delete(int id);

    void update(PersonView personView);
}
