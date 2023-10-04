package com.example.EsercizioSmartphone.DTO;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CasaProduttriceDTO {
    private int id;
    
    private String marca;
    private String paeseRiferimento;
    private String cittaSedeLegale;
    private double fatturato;
    private Date dataRiferimentoFatturato;

    private List<SmartphoneDTO> smartphones;

}
