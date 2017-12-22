package com.dnstth.vtmg.dal.service;

import com.dnstth.vtmg.dal.dto.Gender;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public interface GenderService {
    List<Gender> findAll();

    void delete(Gender gender);

    void add(Gender gender);

    Gender findOne(int id);

    void update(Gender gender);
}
