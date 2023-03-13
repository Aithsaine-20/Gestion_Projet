package com.example.evatuation_jpahibernate.services;

import com.example.evatuation_jpahibernate.entities.Projet;
import com.example.evatuation_jpahibernate.entities.Tache;
import com.example.evatuation_jpahibernate.exception.NullTacheException;
import org.springframework.stereotype.Service;

@Service
public interface TacheService {
    public Tache addTache(Tache tache);
    public Tache updateTache(Tache tache);
    public void deleteTache(Tache tache);
    public Tache getTacheById(Long idTache) throws NullTacheException;
}
