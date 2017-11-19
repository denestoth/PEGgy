package com.dnstth.vtmg.service;

import com.dnstth.vtmg.view.GenderView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface GenderService {

    List<GenderView> getAll();

    GenderView getOne(int id);

    void add(GenderView genderView);

    void delete(int id);

    void update(GenderView genderView);
}
