package com.example.EsercizioSmartphone.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EsercizioSmartphone.DTO.UtenteDTO;
import com.example.EsercizioSmartphone.Mapper.UtenteMapper;
import com.example.EsercizioSmartphone.entity.Utente;
import com.example.EsercizioSmartphone.service.SmartphoneService;
import com.example.EsercizioSmartphone.service.UtenteService;

import exception.SmartphoneNotFoundException;
import exception.UtenteNotFoundException;

@RestController
@RequestMapping("/api/utente")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteMapper utenteMapper;
    
    @Autowired
    private SmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Utente> createUtente(@RequestBody Utente utente) {
        Utente savedUtente = utenteService.saveUtente(utente);
        return new ResponseEntity<>(savedUtente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UtenteDTO>> getAllUtenti() {
        List<Utente> utenteList = utenteService.getAllUtenti();
        List<UtenteDTO> utenteDTOList = utenteList.stream()
                .map(utenteMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(utenteDTOList, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UtenteDTO> getUtenteById(@PathVariable("id") int id) {
        Utente utente = utenteService.getUtenteById(id);
        UtenteDTO utenteDTO = utenteMapper.toDTO(utente);
        return new ResponseEntity<>(utenteDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtente(@PathVariable("id") int id) {
        utenteService.deleteUtente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/smartphone")
    public ResponseEntity<String> assignUtenteToSmartphone(
        @RequestBody Map<String, Object> requestMap
    ) {
        try {
            int utenteId = (int) requestMap.get("utenteId");
            @SuppressWarnings("unchecked")
			List<Integer> smartphoneIds = (List<Integer>) requestMap.get("smartphoneIds");

            for (int smartphoneId : smartphoneIds) {
                smartphoneService.assignUtenteToSmartphone(smartphoneId, utenteId);
            }

            return new ResponseEntity<>("Utenti assegnati ai telefoni con successo", HttpStatus.OK);
        } catch (SmartphoneNotFoundException e) {
            return new ResponseEntity<>("Smartphone non trovato", HttpStatus.NOT_FOUND);
        } catch (UtenteNotFoundException e) {
            return new ResponseEntity<>("Utente non trovato", HttpStatus.NOT_FOUND);
        }
    }


}