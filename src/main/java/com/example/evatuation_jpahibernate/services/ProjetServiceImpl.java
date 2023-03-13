package com.example.evatuation_jpahibernate.services;

import com.example.evatuation_jpahibernate.entities.Projet;
import com.example.evatuation_jpahibernate.entities.Tache;
import com.example.evatuation_jpahibernate.exception.NullProjectException;
import com.example.evatuation_jpahibernate.repositories.ProjetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProjetServiceImpl implements ProjetService {
    @Autowired
    ProjetRepository projetRepository;

    @Override
    public Projet addProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet updateProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(Projet projet) {
        projetRepository.delete(projet);
    }

    @Override
    public void deleteTachesFromProjet(Long idProjet) throws NullProjectException {
        Projet projet= getProjetById(idProjet);
        projet.getTaches().clear();
        projetRepository.save(projet);
    }

    @Override
    public Tache addTacheToProjet(Long idProjet, Tache tache) throws NullProjectException {
        Projet projet=getProjetById(idProjet);
        projet.getTaches().add(tache);
        tache.setProjet(projet);
        projetRepository.save(projet);
        return tache;
    }


    @Override
    public List<Projet> rechercherProjets() {
        return projetRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Projet getProjetById(Long idProjet) throws NullProjectException {

        return projetRepository.findById(idProjet).orElseThrow(()->new NullProjectException("this project is not exist"));
    }

    @Override
    public void addProjetByParam(Projet projet) {
        projetRepository.insertProjet(projet.getTitre(), projet.getDescription());
    }
}
