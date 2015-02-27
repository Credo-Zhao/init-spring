package org.zhaoqian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zhaoqian.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    
}
