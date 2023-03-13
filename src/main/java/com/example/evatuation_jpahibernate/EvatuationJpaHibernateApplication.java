package com.example.evatuation_jpahibernate;

import com.example.evatuation_jpahibernate.entities.Projet;
import com.example.evatuation_jpahibernate.entities.Tache;
import com.example.evatuation_jpahibernate.entities.Utilisateur;
import com.example.evatuation_jpahibernate.repositories.ProjetRepository;
import com.example.evatuation_jpahibernate.services.ProjetService;
import com.example.evatuation_jpahibernate.services.TacheService;
import com.example.evatuation_jpahibernate.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvatuationJpaHibernateApplication implements CommandLineRunner {

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    ProjetService projetService;

    @Autowired
    TacheService tacheService;

    public static void main(String[] args) {
        SpringApplication.run(EvatuationJpaHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // create a new utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("hicham ait hsiane");
        utilisateur.setEmail("hichamAit@example.com");

        // save the utilisateur to the database
        utilisateurService.addUtilisateur(utilisateur);

        // create a new projet
        Projet projet = new Projet();
        projet.setTitre("Project 1");
        projet.setDescription("This is project 1");
        projet.setUtilisateur(utilisateur);

        Projet projet2 = new Projet();
        projet2.setTitre("Project 2");
        projet2.setDescription("This is project 2");
        projet2.setUtilisateur(utilisateur);

        Projet projet3 = new Projet();
        projet3.setTitre("Project 3");
        projet3.setDescription("This is project 3");
        projet3.setUtilisateur(utilisateur);

        // save the projet to the database
        projetService.addProjet(projet);
        projetService.addProjet(projet2);


        // create a new tache
        Tache tache1 = new Tache();
        tache1.setTitre("Task 1");
        tache1.setDescription("This is task 1");
        tache1.setProjet(projet);

        Tache tache2 = new Tache();
        tache2.setTitre("Task 1");
        tache2.setDescription("This is task 2");
        tache2.setProjet(projet);

        Tache tache3 = new Tache();
        tache3.setTitre("Task 3");
        tache3.setDescription("This is task 3");

        Tache tache4 = new Tache();
        tache4.setTitre("Task 4");
        tache4.setDescription("This is task 4");
        tache4.setProjet(projet2);

        Tache tache5 = new Tache();
        tache5.setTitre("Task 5");
        tache5.setDescription("This is task 5");
        tache5.setProjet(projet2);

        tacheService.addTache(tache1);
        tacheService.addTache(tache2);
        tacheService.addTache(tache3);
        tacheService.addTache(tache4);
        tacheService.addTache(tache5);

        System.out.println(projet.toString());

        System.out.println("******* méthodes Rechercher() pour toutes les entités avec un tri asc by ID *******");
        projetService.rechercherProjets().forEach(p->System.out.println(p.getTitre()));
        System.out.println("******* la méthode qui permet de persister un projet en utilisant une requête nommé *******");
        projetService.addProjetByParam(projet3);
        System.out.println("******* méthode qui permet d’ajouter une tache à un projet existant *******");

        projetService.addTacheToProjet(1L,tache3);
        System.out.println(projetService.getProjetById(1L).getTitre());



        System.out.println("******* de supprimer tous les tâches liées à un projet  *******");
        projetService.deleteTachesFromProjet(2L);

        System.out.println("******* méthode qui permet la suppression d’un utilisateur *******");
        utilisateurService.getUtilisateurById(1L);


    }
}
