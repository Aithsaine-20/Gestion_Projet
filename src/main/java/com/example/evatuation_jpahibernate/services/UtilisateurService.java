package com.example.evatuation_jpahibernate.services;

import com.example.evatuation_jpahibernate.entities.Utilisateur;
import com.example.evatuation_jpahibernate.exception.NullUtilisateurException;
import org.springframework.stereotype.Service;


public interface UtilisateurService {
    public Utilisateur addUtilisateur(Utilisateur utilisateur);
    public Utilisateur updateUtilisateur(Utilisateur utilisateur);
    public void deleteUtilisateur(Utilisateur utilisateur);
    public void deleteUtilisateurById(Long idUtilisateur);
    public Utilisateur getUtilisateurById(Long idUtilisateur) throws NullUtilisateurException;
}
