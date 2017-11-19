package com.dnstth.vtmg.dal.repository;

import com.dnstth.vtmg.dal.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Denes_Toth
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
