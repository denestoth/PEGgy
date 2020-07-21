package com.dnstth.vtmg.view;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonView {

    private int id;

    private String name;

    private Date birthDate;

    private Date deathDate;

    private String details;

    private KindView kind;

    private GenderView gender;

    private List<EventView> events;
}
