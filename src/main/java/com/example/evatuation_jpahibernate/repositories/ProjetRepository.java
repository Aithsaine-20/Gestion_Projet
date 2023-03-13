package com.example.evatuation_jpahibernate.repositories;

import com.example.evatuation_jpahibernate.entities.Projet;
import com.example.evatuation_jpahibernate.entities.Utilisateur;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Modifying
    @Transactional
    public void insertProjet(@Param("titre") String titre, @Param("description") String description);
}
