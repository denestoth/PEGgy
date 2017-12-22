package com.dnstth.vtmg.dal.service;

import com.dnstth.vtmg.dal.dto.Kind;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface KindService {
    List<Kind> findAll();

    void delete(Kind gender);

    void add(Kind gender);

    Kind findOne(int id);

    void update(Kind kind);
}
