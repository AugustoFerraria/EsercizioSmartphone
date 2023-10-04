package com.example.EsercizioSmartphone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EsercizioSmartphone.DTO.CasaProduttriceDTO;
import com.example.EsercizioSmartphone.Mapper.CasaProduttriceMapper;
import com.example.EsercizioSmartphone.entity.CasaProduttrice;
import com.example.EsercizioSmartphone.repository.CasaProduttriceRepository;

import exception.CasaProduttriceNotFoundException;
import exception.SmartphoneNotFoundException;

@Service
public class CasaProduttriceService {
    @Autowired
    private CasaProduttriceRepository casaProduttriceRepository;
    @Autowired
    private CasaProduttriceMapper casaProduttriceMapper;

    public CasaProduttrice saveCasaProduttrice(CasaProduttrice casaProduttrice) {
        return casaProduttriceRepository.save(casaProduttrice);
    }

    public List<CasaProduttriceDTO> getAllCasaProduttrici() {
        List<CasaProduttrice> casaProduttriceList = casaProduttriceRepository.findAll();
        return casaProduttriceList.stream()
                .map(casaProduttriceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CasaProduttrice getCasaProduttriceById(int casaProduttriceId) {
        return casaProduttriceRepository.findById(casaProduttriceId)
                .orElseThrow(() -> new CasaProduttriceNotFoundException("Casa produttrice con id " + casaProduttriceId + " non esiste"));
    }



    public void deleteCasaProduttrice(int casaProduttriceId) {
        if (!casaProduttriceRepository.existsById(casaProduttriceId)) {
            throw new SmartphoneNotFoundException("La casa produttrice con l'ID " + casaProduttriceId + " non esiste");
        }
        casaProduttriceRepository.deleteById(casaProduttriceId);
    }

    public void addCasaProduttrice(CasaProduttrice casaProduttrice) {
        casaProduttriceRepository.save(casaProduttrice);
    }
}