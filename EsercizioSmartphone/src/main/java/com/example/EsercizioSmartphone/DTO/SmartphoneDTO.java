package com.example.EsercizioSmartphone.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmartphoneDTO {
    private int ID;
    
    private String modello;
    private double prezzoAcquisto;
    private int annoProduzione;
}
