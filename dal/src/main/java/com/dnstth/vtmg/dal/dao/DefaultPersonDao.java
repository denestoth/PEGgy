package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.PersonRepository;
import com.dnstth.vtmg.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public class DefaultPersonDao implements PersonDao {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public void delete(Person person){
        personRepository.delete(person);
    }

    public void add(Person person) {
        personRepository.save(person);
    }
}
