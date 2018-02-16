package com.dnstth.vtmg.dal.facade;

import com.dnstth.vtmg.view.GenderView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface GenderFacade {

    List<GenderView> getAll();

    GenderView getOne(int id);

    void add(GenderView genderView);

    void delete(int id);

    void update(GenderView genderView);
}
