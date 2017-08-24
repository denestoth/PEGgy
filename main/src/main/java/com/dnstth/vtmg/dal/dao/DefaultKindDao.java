package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.KindRepository;
import com.dnstth.vtmg.dal.dto.Kind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denes_Toth
 */
@Component
public class DefaultKindDao implements KindDao {

    @Autowired
    private KindRepository kindRepository;

    @Override
    public List<Kind> findAll() {
        return kindRepository.findAll();
    }

    @Override
    public void delete(Kind kind) {
        kindRepository.delete(kind);
    }

    @Override
    public void add(Kind kind) {
        kindRepository.save(kind);
    }

    @Override
    public Kind findOne(int id) {
        Optional<Kind> optional = kindRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

}
