package com.example.EsercizioSmartphone.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.EsercizioSmartphone.DTO.UtenteDTO;
import com.example.EsercizioSmartphone.entity.Utente;

@Component
public class UtenteMapper {

    private final ModelMapper modelMapper;

    public UtenteMapper() {
        this.modelMapper = new ModelMapper();
    }

    public UtenteDTO toDTO(Utente utente) {
        return modelMapper.map(utente, UtenteDTO.class);
    }

    public Utente toEntity(UtenteDTO utenteDTO) {
        return modelMapper.map(utenteDTO, Utente.class);
    }
}
