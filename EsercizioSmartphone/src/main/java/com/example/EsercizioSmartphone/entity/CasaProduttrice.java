package com.example.EsercizioSmartphone.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CasaProduttrice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CasaProduttrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String marca;
    private String paeseRiferimento;
    private String cittaSedeLegale;
    private double fatturato;
    private Date dataRiferimentoFatturato;

    @JsonIgnore
    @OneToMany(mappedBy = "casaProduttrice")
    private List<Smartphone> smartphones;
}
