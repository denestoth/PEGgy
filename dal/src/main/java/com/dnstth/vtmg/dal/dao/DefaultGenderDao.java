package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.GenderRepository;
import com.dnstth.vtmg.domain.Gender;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public class DefaultGenderDao implements GenderDao {

    @Autowired
    private GenderRepository genderRepository;

    public List<Gender> findAll(){
        return genderRepository.findAll();
    }

    public void delete(Gender gender){
        genderRepository.delete(gender);
    }

    public void add(Gender gender) {
        genderRepository.save(gender);
    }
}
