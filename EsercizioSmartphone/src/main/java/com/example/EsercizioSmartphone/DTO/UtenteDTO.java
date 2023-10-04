package com.example.EsercizioSmartphone.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDTO {
    private int ID;
    
    private String nome;
    private String cognome;
    private String citta;
    private String email;
    private String numeroTelefono;
    private int annoNascita;
    
    private List<SmartphoneDTO> smartphones;
}
