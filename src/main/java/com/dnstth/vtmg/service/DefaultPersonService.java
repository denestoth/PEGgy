package com.dnstth.vtmg.service;

import com.dnstth.vtmg.dal.dao.PersonDao;
import com.dnstth.vtmg.transformer.PersonTransformer;
import com.dnstth.vtmg.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultPersonService implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonTransformer personTransformer;

    @Override
    public List<PersonView> getAll() {
        return personTransformer.dtosToViews(personDao.findAll());
    }

    @Override
    public PersonView getOne(int id) {
        return personTransformer.dtoToView(personDao.findOne(id));
    }

    @Override
    public void add(PersonView personView) {
        personDao.add(personTransformer.viewToDto(personView));
    }

    @Override
    public void delete(int id) {
        personDao.delete(personDao.findOne(id));
    }

    @Override
    public void update(PersonView personView) {
        personDao.update(personTransformer.viewToDto(personView));
    }
}
