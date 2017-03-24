package com.dnstth.vtmg.dal.dao;

import com.dnstth.vtmg.dal.repository.KindRepository;
import com.dnstth.vtmg.domain.Kind;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Denes_Toth
 */
public class DefaultKindDao implements KindDao {

    @Autowired
    private KindRepository kindRepository;

    public List<Kind> findAll(){
        return kindRepository.findAll();
    }

    public void delete(Kind kind){
        kindRepository.delete(kind);
    }

    public void add(Kind kind){
        kindRepository.save(kind);
    }

}
