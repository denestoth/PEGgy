package com.dnstth.vtmg.dal.facade;

import com.dnstth.vtmg.view.KindView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface KindFacade {

    List<KindView> getAll();

    KindView getOne(int id);

    void add(KindView kindView);

    void delete(int id);

    void update(KindView kindView);
}
