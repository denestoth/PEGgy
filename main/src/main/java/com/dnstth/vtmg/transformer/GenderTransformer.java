package com.dnstth.vtmg.transformer;

import com.dnstth.vtmg.dal.dto.Gender;
import com.dnstth.vtmg.view.GenderView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        List<Gender> genders = new ArrayList<Gender>();

        for(GenderView genderView : genderViews){
            genders.add(viewToDto(genderView));
        }

        return genders;
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
        List<GenderView> genderViews = new ArrayList<GenderView>();

        for (Gender gender : genders){
            genderViews.add(dtoToView(gender));
        }

        return genderViews;
    }
}
