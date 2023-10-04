package com.example.EsercizioSmartphone.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Utente")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    
    private String nome;
    private String cognome;
    private String citta;
    private String email;
    private String numeroTelefono;
    private int annoNascita;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "utente_smartphone",
        joinColumns = { @JoinColumn(name = "utente_id") },
        inverseJoinColumns = { @JoinColumn(name = "smartphone_id") }
    )
 
    private List<Smartphone> smartphones;

}
