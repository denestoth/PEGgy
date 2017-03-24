package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.SexRepository;
import com.dnstth.vtmg.domain.Sex;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public class DefaultSexDao implements SexDao {

    @Autowired
    private SexRepository sexRepository;

    public List<Sex> findAll(){
        return sexRepository.findAll();
    }

    public void delete(Sex sex){
        sexRepository.delete(sex);
    }

    public void add(Sex sex) {
        sexRepository.save(sex);
    }
}
