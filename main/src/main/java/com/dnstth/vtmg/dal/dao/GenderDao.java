package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.dto.Gender;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface GenderDao {

    List<Gender> findAll();

    void delete(Gender gender);

    void add(Gender gender);

    Gender findOne(int id);
}
