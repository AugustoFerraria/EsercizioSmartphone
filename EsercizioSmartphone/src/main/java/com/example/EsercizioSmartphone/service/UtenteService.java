package com.example.EsercizioSmartphone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EsercizioSmartphone.entity.Smartphone;
import com.example.EsercizioSmartphone.entity.Utente;
import com.example.EsercizioSmartphone.repository.SmartphoneRepository;
import com.example.EsercizioSmartphone.repository.UtenteRepository;

import exception.SmartphoneNotFoundException;
import exception.UtenteNotFoundException;

@Service
public class UtenteService {
	@Autowired
    private UtenteRepository utenteRepository;
    private SmartphoneRepository smartphoneRepository;

    public Utente saveUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(int utenteId) {
        return utenteRepository.findById(utenteId)
                .orElseThrow(() -> new UtenteNotFoundException("L'utente con l'id " + utenteId + " non esiste"));
    }
    
    public void assignSmartphonesToUtente(int utenteId, List<Integer> smartphoneIds) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow(() -> new UtenteNotFoundException("Utente non trovato"));

        List<Smartphone> smartphones = smartphoneRepository.findAllById(smartphoneIds);
        utente.getSmartphones().addAll(smartphones);
        utenteRepository.save(utente);
    }

    
    public void deleteUtente(int utenteId) {
        if(!utenteRepository.existsById(utenteId)) {
            throw new UtenteNotFoundException("L'utente con l'id " + utenteId + " non esiste");
        }
        utenteRepository.deleteById((int) utenteId);
    }
        
    public void addUtente(Utente utente){ utenteRepository.save(utente);}

}