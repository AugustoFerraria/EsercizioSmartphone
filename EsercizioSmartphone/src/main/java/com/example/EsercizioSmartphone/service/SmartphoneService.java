package com.example.EsercizioSmartphone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EsercizioSmartphone.entity.CasaProduttrice;
import com.example.EsercizioSmartphone.entity.Smartphone;
import com.example.EsercizioSmartphone.entity.Utente;
import com.example.EsercizioSmartphone.repository.SmartphoneRepository;

import exception.SmartphoneNotFoundException;

@Service
public class SmartphoneService {
    @Autowired
    private SmartphoneRepository smartphoneRepository;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private CasaProduttriceService casaProduttriceService;


    public Smartphone saveSmartphone(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    public List<Smartphone> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    public void deleteSmartphone(int smartphoneId) {
        if (!smartphoneRepository.existsById(smartphoneId)) {
            throw new SmartphoneNotFoundException("Lo smartphone con l'ID " + smartphoneId + " non esiste");
        }
        smartphoneRepository.deleteById(smartphoneId);
    }

    public void assignUtenteToSmartphone(int smartphoneId, int utenteId) {
        Smartphone smartphone = smartphoneRepository.findById(smartphoneId)
            .orElseThrow(() -> new SmartphoneNotFoundException("Smartphone non trovato"));

        Utente utente = utenteService.getUtenteById(utenteId);

        List<Smartphone> smartphones = utente.getSmartphones();
        smartphones.add(smartphone);
        utente.setSmartphones(smartphones);
        utenteService.saveUtente(utente);
    }

    public void updateCasaProduttriceId(int smartphoneId, int casaProduttriceId) {
        Smartphone smartphone = smartphoneRepository.findById(smartphoneId)
                .orElseThrow(() -> new SmartphoneNotFoundException("Lo smartphone con l'ID " + smartphoneId + " non esiste"));

        CasaProduttrice casaProduttrice = casaProduttriceService.getCasaProduttriceById(casaProduttriceId);

        smartphone.setCasaProduttrice(casaProduttrice);
        smartphoneRepository.save(smartphone);
    }

}
