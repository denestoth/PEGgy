package com.dnstth.vtmg.service;

import com.dnstth.vtmg.dal.dao.GenderDao;
import com.dnstth.vtmg.transformer.GenderTransformer;
import com.dnstth.vtmg.view.GenderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultGenderService implements GenderService {

    @Autowired
    private GenderDao genderDao;

    @Autowired
    private GenderTransformer genderTransformer;

    @Override
    public List<GenderView> getAll() {
        return genderTransformer.dtosToViews(genderDao.findAll());
    }

    @Override
    public GenderView getOne(int id) {
        return genderTransformer.dtoToView(genderDao.findOne(id));
    }

    @Override
    public void add(GenderView genderView) {
        genderDao.add(genderTransformer.viewToDto(genderView));
    }

    @Override
    public void delete(int id) {
        genderDao.delete(genderDao.findOne(id));
    }

    @Override
    public void update(GenderView genderView) {
        genderDao.update(genderTransformer.viewToDto(genderView));
    }
}
