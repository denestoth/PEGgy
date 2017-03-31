package com.dnstth.vtmg.service;

import com.dnstth.vtmg.dal.dao.KindDao;
import com.dnstth.vtmg.transformer.KindTransformer;
import com.dnstth.vtmg.view.KindView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultKindService implements  KindService {

    @Autowired
    private KindDao kindDao;

    @Autowired
    private KindTransformer kindTransformer;

    @Override
    public List<KindView> getAll() {
        return kindTransformer.dtosToViews(kindDao.findAll());
    }

    @Override
    public void add(KindView genderView) {
        kindDao.add(kindTransformer.viewToDto(genderView));
    }

    @Override
    public void delete(int id) {
        kindDao.delete(kindDao.findOne(id));
    }
}
