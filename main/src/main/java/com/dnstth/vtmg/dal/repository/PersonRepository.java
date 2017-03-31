package com.dnstth.vtmg.dal.repository;

import com.dnstth.vtmg.dal.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Denes_Toth
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
