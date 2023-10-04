package com.example.EsercizioSmartphone.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.EsercizioSmartphone.DTO.CasaProduttriceDTO;
import com.example.EsercizioSmartphone.entity.CasaProduttrice;

@Component
	public class CasaProduttriceMapper {

	    private final ModelMapper modelMapper;

	    public CasaProduttriceMapper() {
	        this.modelMapper = new ModelMapper();
	    }

	    public CasaProduttriceDTO toDTO(CasaProduttrice casaProduttrice) {
	        return modelMapper.map(casaProduttrice, CasaProduttriceDTO.class);
	    }

	    public CasaProduttrice toEntity(CasaProduttriceDTO casaProduttriceDTO) {
	        return modelMapper.map(casaProduttriceDTO, CasaProduttrice.class);
	    }
	}