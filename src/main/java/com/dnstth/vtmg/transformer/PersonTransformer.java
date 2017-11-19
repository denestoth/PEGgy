package com.dnstth.vtmg.transformer;

import com.dnstth.vtmg.dal.dto.Person;
import com.dnstth.vtmg.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denes_Toth
 */
@Component
public class PersonTransformer implements Transformer<Person, PersonView> {

    @Autowired
    private EventTransformer eventTransformer;

    @Autowired
    private GenderTransformer genderTransformer;

    @Autowired
    private KindTransformer kindTransformer;

        @Override
    public Person viewToDto(PersonView personView) {
        Person person = new Person();
        person.setId(personView.getId());
        person.setName(personView.getName());
        try {
            person.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(personView.getBirthDate()));
            person.setDeathDate(new SimpleDateFormat("yyyy-MM-dd").parse(personView.getDeathDate()));
        } catch(ParseException e) {

        }
        person.setDetails(personView.getDetails());
        person.setEvents(eventTransformer.viewsToDtos(personView.getEvents()));
        person.setGender(genderTransformer.viewToDto(personView.getGender()));
        person.setKind(kindTransformer.viewToDto(personView.getKind()));
        return person;
    }

    @Override
    public List<Person> viewsToDtos(List<PersonView> personViews) {
        return personViews.stream().map(pv -> viewToDto(pv)).collect(Collectors.toList());
    }

    @Override
    public PersonView dtoToView(Person person) {
        PersonView personView = new PersonView();
        personView.setId(person.getId());
        personView.setName(person.getName());
        personView.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").format(person.getBirthDate()));
        personView.setDeathDate(new SimpleDateFormat("yyyy-MM-dd").format(person.getDeathDate()));
        personView.setDetails(person.getDetails());
        personView.setEvents(eventTransformer.dtosToViews(person.getEvents()));
        personView.setGender(genderTransformer.dtoToView(person.getGender()));
        personView.setKind(kindTransformer.dtoToView(person.getKind()));
        return personView;
    }

    @Override
    public List<PersonView> dtosToViews(List<Person> people) {
        return people.stream().map(p -> dtoToView(p)).collect(Collectors.toList());
    }
}
