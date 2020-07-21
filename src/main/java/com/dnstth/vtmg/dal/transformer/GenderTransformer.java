package com.dnstth.vtmg.dal.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dnstth.vtmg.dal.dto.Gender;
import com.dnstth.vtmg.view.GenderView;
import org.springframework.stereotype.Component;

/**
 * Created by Denes_Toth
 */
@Component
public class GenderTransformer implements Transformer<Gender, GenderView> {

    @Override
    public Gender viewToDto(GenderView genderView) {
        return Gender.builder()
                   .id(genderView.getId())
                   .description(genderView.getDescription())
                   .build();
    }

    @Override
    public List<Gender> viewsToDtos(List<GenderView> genderViews) {
        return genderViews != null ? genderViews.stream().map(gv -> viewToDto(gv)).collect(Collectors.toList()) : null;
    }

    @Override
    public GenderView dtoToView(Gender gender) {
        return GenderView.builder()
                   .id(gender.getId())
                   .description(gender.getDescription())
                   .build();
    }

    @Override
    public List<GenderView> dtosToViews(List<Gender> genders) {
        return genders != null ? genders.stream().map(g -> dtoToView(g)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
