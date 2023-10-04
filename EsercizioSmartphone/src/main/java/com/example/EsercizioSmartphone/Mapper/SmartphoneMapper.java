package com.example.EsercizioSmartphone.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.EsercizioSmartphone.DTO.SmartphoneDTO;
import com.example.EsercizioSmartphone.entity.Smartphone;

@Component
public class SmartphoneMapper {

    private final ModelMapper modelMapper;

    public SmartphoneMapper() {
        this.modelMapper = new ModelMapper();
    }

    public SmartphoneDTO toDTO(Smartphone smartphone) {
        return modelMapper.map(smartphone, SmartphoneDTO.class);
    }

    public Smartphone toEntity(SmartphoneDTO smartphoneDTO) {
        return modelMapper.map(smartphoneDTO, Smartphone.class);
    }
}

