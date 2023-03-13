package com.example.evatuation_jpahibernate.services;

import com.example.evatuation_jpahibernate.entities.Utilisateur;
import com.example.evatuation_jpahibernate.exception.NullUtilisateurException;
import com.example.evatuation_jpahibernate.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }

    @Override
    public void deleteUtilisateurById(Long idUtilisateur) {
        utilisateurRepository.deleteById(idUtilisateur);
    }

    @Override
    public Utilisateur getUtilisateurById(Long idUtilisateur) throws NullUtilisateurException {
        return utilisateurRepository.findById(idUtilisateur).orElseThrow(()->new NullUtilisateurException("this user is not exist"));
    }
}
