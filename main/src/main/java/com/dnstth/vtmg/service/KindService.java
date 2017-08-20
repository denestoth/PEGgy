package com.dnstth.vtmg.service;

import com.dnstth.vtmg.view.KindView;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface KindService {

    List<KindView> getAll();

    void add(KindView kindView);

    void delete(int id);
}
