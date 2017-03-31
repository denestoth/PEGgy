package com.dnstth.vtmg.dal.repository;

import com.dnstth.vtmg.dal.dto.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Denes_Toth
 */
public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
