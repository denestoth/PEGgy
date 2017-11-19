package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.GenderRepository;
import com.dnstth.vtmg.dal.dto.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denes_Toth
 */
@Component
public class DefaultGenderDao implements GenderDao {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public void delete(Gender gender) {
        genderRepository.delete(gender);
    }

    @Override
    public void add(Gender gender) {
        genderRepository.save(gender);
    }

    @Override
    public Gender findOne(int id) {
        Optional<Gender> optional = genderRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public void update(Gender gender) {
        genderRepository.saveAndFlush(gender);
    }
}
