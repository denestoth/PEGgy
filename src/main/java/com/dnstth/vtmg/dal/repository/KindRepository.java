package com.dnstth.vtmg.dal.repository;

import com.dnstth.vtmg.dal.dto.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Denes_Toth
 */
@Repository
public interface KindRepository extends JpaRepository<Kind, Integer> {
}
