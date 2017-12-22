package com.dnstth.vtmg.facade;

import com.dnstth.vtmg.dal.service.KindService;
import com.dnstth.vtmg.transformer.KindTransformer;
import com.dnstth.vtmg.view.KindView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denes_Toth
 */
@Service
public class DefaultKindFacade implements KindFacade {

    @Autowired
    private KindService kindService;

    @Autowired
    private KindTransformer kindTransformer;

    @Override
    public List<KindView> getAll() {
        return kindTransformer.dtosToViews(kindService.findAll());
    }

    @Override
    public KindView getOne(int id) {
        return kindTransformer.dtoToView(kindService.findOne(id));
    }

    @Override
    public void add(KindView kindView) {
        kindService.add(kindTransformer.viewToDto(kindView));
    }

    @Override
    public void delete(int id) {
        kindService.delete(kindService.findOne(id));
    }

    @Override
    public void update(KindView kindView) {
        kindService.update(kindTransformer.viewToDto(kindView));
    }
}
