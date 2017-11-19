package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.dto.Person;
import com.dnstth.vtmg.dal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denes_Toth
 */
@Component
public class DefaultPersonDao implements PersonDao {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findOne(int id) {
        Optional<Person> optional = personRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public void update(Person person) {
        personRepository.saveAndFlush(person);
    }
}
