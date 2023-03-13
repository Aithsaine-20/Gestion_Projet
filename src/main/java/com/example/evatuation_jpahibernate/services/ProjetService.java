package com.example.evatuation_jpahibernate.services;

import com.example.evatuation_jpahibernate.entities.Projet;
import com.example.evatuation_jpahibernate.entities.Tache;
import com.example.evatuation_jpahibernate.entities.Utilisateur;
import com.example.evatuation_jpahibernate.exception.NullProjectException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjetService {
    public Projet addProjet(Projet projet);
    public Projet updateProjet(Projet projet);
    public void deleteProjet(Projet projet);
    public void deleteTachesFromProjet(Long idProjet) throws NullProjectException;
    public Tache addTacheToProjet(Long idProjet,Tache tache) throws NullProjectException;
    public List<Projet> rechercherProjets();
    public Projet getProjetById(Long idProjet) throws NullProjectException;
    public void addProjetByParam(Projet projet);
}
