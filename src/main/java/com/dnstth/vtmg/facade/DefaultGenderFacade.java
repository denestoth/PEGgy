package com.dnstth.vtmg.facade;

import com.dnstth.vtmg.dal.service.GenderService;
import com.dnstth.vtmg.transformer.GenderTransformer;
import com.dnstth.vtmg.view.GenderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultGenderFacade implements GenderFacade {

    @Autowired
    private GenderService genderService;

    @Autowired
    private GenderTransformer genderTransformer;

    @Override
    public List<GenderView> getAll() {
        return genderTransformer.dtosToViews(genderService.findAll());
    }

    @Override
    public GenderView getOne(int id) {
        return genderTransformer.dtoToView(genderService.findOne(id));
    }

    @Override
    public void add(GenderView genderView) {
        genderService.add(genderTransformer.viewToDto(genderView));
    }

    @Override
    public void delete(int id) {
        genderService.delete(genderService.findOne(id));
    }

    @Override
    public void update(GenderView genderView) {
        genderService.update(genderTransformer.viewToDto(genderView));
    }
}
