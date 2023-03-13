package com.example.evatuation_jpahibernate.services;

import com.example.evatuation_jpahibernate.entities.Tache;
import com.example.evatuation_jpahibernate.exception.NullTacheException;
import com.example.evatuation_jpahibernate.repositories.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacheServiceImpl implements TacheService {
    @Autowired
    TacheRepository tacheRepository;


    @Override
    public Tache addTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache updateTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public void deleteTache(Tache tache) {
        tacheRepository.delete(tache);
    }

    @Override
    public Tache getTacheById(Long idTache) throws NullTacheException {

        return tacheRepository.findById(idTache).orElseThrow(()->new NullTacheException("this tache is not exist"));
    }
}
