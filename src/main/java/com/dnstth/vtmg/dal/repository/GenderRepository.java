package com.dnstth.vtmg.dal.repository;

import com.dnstth.vtmg.dal.dto.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Denes_Toth
 */
@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
