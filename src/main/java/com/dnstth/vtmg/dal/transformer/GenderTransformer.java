package com.dnstth.vtmg.dal.transformer;

import com.dnstth.vtmg.dal.dto.Gender;
import com.dnstth.vtmg.view.GenderView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denes_Toth
 */
@Component
public class GenderTransformer implements Transformer<Gender, GenderView> {

    @Override
    public Gender viewToDto(GenderView genderView) {
        Gender gender = new Gender();
        gender.setId(genderView.getId());
        gender.setDescription(genderView.getDescription());
        return gender;
    }

    @Override
    public List<Gender> viewsToDtos(List<GenderView> genderViews) {
        return genderViews != null ? genderViews.stream().map(gv -> viewToDto(gv)).collect(Collectors.toList()) : null;
    }

    @Override
    public GenderView dtoToView(Gender gender) {
        GenderView genderView = new GenderView();
        genderView.setId(gender.getId());
        genderView.setDescription(gender.getDescription());
        return genderView;
    }

    @Override
    public List<GenderView> dtosToViews(List<Gender> genders) {
        return genders != null ? genders.stream().map(g -> dtoToView(g)).collect(Collectors.toList()) : new ArrayList<>();
    }
}
