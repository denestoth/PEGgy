package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.dto.Person;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface PersonDao {

    List<Person> findAll();

    void delete(Person gender);

    void add(Person gender);

    Person findOne(int id);
}
