package com.dnstth.vtmg.dal.service;

import com.dnstth.vtmg.dal.dto.Kind;
import com.dnstth.vtmg.dal.repository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Denes_Toth
 */
@Component
public class DefaultKindService implements KindService {

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
        return optional.orElse(null);
    }

    @Override
    public void update(Kind kind) {
        kindRepository.saveAndFlush(kind);
    }
}
