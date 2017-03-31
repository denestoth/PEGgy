package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.dto.Kind;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface KindDao {

    List<Kind> findAll();

    void delete(Kind gender);

    void add(Kind gender);

    Kind findOne(int id);
}
