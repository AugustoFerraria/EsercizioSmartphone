package com.example.EsercizioSmartphone.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Smartphone")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String modello;
    private double prezzoAcquisto;
    private int annoProduzione;

    @ManyToOne
    @JoinColumn(name = "marca")
    private CasaProduttrice casaProduttrice;

    @JsonIgnore
    @ManyToMany(mappedBy = "smartphones")
    private List<Utente> utente;
}
