package com.example.evatuation_jpahibernate.repositories;

import com.example.evatuation_jpahibernate.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
}
