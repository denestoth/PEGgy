package com.dnstth.vtmg.view;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlaceView {

    private int id;

    private String name;

    private String details;
}
