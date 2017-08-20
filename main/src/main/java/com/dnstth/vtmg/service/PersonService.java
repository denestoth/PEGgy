package com.dnstth.vtmg.service;

import com.dnstth.vtmg.view.PersonView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PersonService {

    List<PersonView> getAll();

    void add(PersonView personView);

    void delete(int id);
}
