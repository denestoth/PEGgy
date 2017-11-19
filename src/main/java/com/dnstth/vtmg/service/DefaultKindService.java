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
public class DefaultKindService implements KindService {

    @Autowired
    private KindDao kindDao;

    @Autowired
    private KindTransformer kindTransformer;

    @Override
    public List<KindView> getAll() {
        return kindTransformer.dtosToViews(kindDao.findAll());
    }

    @Override
    public KindView getOne(int id) {
        return kindTransformer.dtoToView(kindDao.findOne(id));
    }

    @Override
    public void add(KindView kindView) {
        kindDao.add(kindTransformer.viewToDto(kindView));
    }

    @Override
    public void delete(int id) {
        kindDao.delete(kindDao.findOne(id));
    }

    @Override
    public void update(KindView kindView) {
        kindDao.update(kindTransformer.viewToDto(kindView));
    }
}
