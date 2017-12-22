package com.dnstth.vtmg.facade;

import com.dnstth.vtmg.dal.service.PersonService;
import com.dnstth.vtmg.transformer.PersonTransformer;
import com.dnstth.vtmg.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultPersonFacade implements PersonFacade {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonTransformer personTransformer;

    @Override
    public List<PersonView> getAll() {
        return personTransformer.dtosToViews(personService.findAll());
    }

    @Override
    public PersonView getOne(int id) {
        return personTransformer.dtoToView(personService.findOne(id));
    }

    @Override
    public void add(PersonView personView) {
        personService.add(personTransformer.viewToDto(personView));
    }

    @Override
    public void delete(int id) {
        personService.delete(personService.findOne(id));
    }

    @Override
    public void update(PersonView personView) {
        personService.update(personTransformer.viewToDto(personView));
    }
}
