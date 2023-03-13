package com.example.evatuation_jpahibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projets")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@NamedNativeQuery(name = "Projet.insertProjet", query = "INSERT INTO Projet (titre, description) VALUES (:titre, :description)")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL ,fetch =FetchType.EAGER)
    @JsonIgnore
    private List<Tache> taches = new ArrayList<>();



}
