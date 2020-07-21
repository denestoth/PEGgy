package com.dnstth.vtmg.dal.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dnstth.vtmg.dal.dto.Person;
import com.dnstth.vtmg.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return Person.builder()
                   .id(personView.getId())
                   .name(personView.getName())
                   .birthDate(personView.getBirthDate())
                   .deathDate(personView.getDeathDate())
                   .details(personView.getDetails())
                   .events(eventTransformer.viewsToDtos(personView.getEvents()))
                   .gender(genderTransformer.viewToDto(personView.getGender()))
                   .kind(kindTransformer.viewToDto(personView.getKind()))
                   .build();
    }

    @Override
    public List<Person> viewsToDtos(List<PersonView> personViews) {
        return personViews != null ? personViews.stream().map(pv -> viewToDto(pv)).collect(Collectors.toList()) : new ArrayList<>();
    }

    @Override
    public PersonView dtoToView(Person person) {
        return PersonView.builder()
                   .id(person.getId())
                   .name(person.getName())
                   .birthDate(person.getBirthDate())
                   .deathDate(person.getDeathDate())
                   .details(person.getDetails())
                   .gender(genderTransformer.dtoToView(person.getGender()))
                   .kind(kindTransformer.dtoToView(person.getKind()))
                   .build();
    }

    @Override
    public List<PersonView> dtosToViews(List<Person> people) {
        return people != null ? people.stream().map(p -> dtoToView(p)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
