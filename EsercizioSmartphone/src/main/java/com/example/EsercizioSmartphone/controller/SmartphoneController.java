package com.example.EsercizioSmartphone.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EsercizioSmartphone.DTO.SmartphoneDTO;
import com.example.EsercizioSmartphone.Mapper.SmartphoneMapper;
import com.example.EsercizioSmartphone.entity.Smartphone;
import com.example.EsercizioSmartphone.service.SmartphoneService;

import exception.CasaProduttriceNotFoundException;
import exception.SmartphoneNotFoundException;

@RestController
@RequestMapping("/api/smartphone")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;
    @Autowired
    private SmartphoneMapper smartphoneMapper;
    

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        Smartphone savedSmartphone = smartphoneService.saveSmartphone(smartphone);
        return new ResponseEntity<>(savedSmartphone, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<SmartphoneDTO>> getAllSmartphones() {
        List<Smartphone> smartphoneList = smartphoneService.getAllSmartphones();
        List<SmartphoneDTO> smartphoneDTOList = smartphoneList.stream()
                .map(smartphoneMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(smartphoneDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSmartphone(@PathVariable("id") int id) {
        smartphoneService.deleteSmartphone(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{smartphoneId}/casaproduttrice/{casaProduttriceId}")
    public ResponseEntity<String> connectSmartphoneWithCasaProduttrice(
            @PathVariable("smartphoneId") int smartphoneId,
            @PathVariable("casaProduttriceId") int casaProduttriceId) {
        try {
            smartphoneService.updateCasaProduttriceId(smartphoneId, casaProduttriceId);
            return ResponseEntity.ok("Smartphone connected to Casa Produttrice successfully");
        } catch (SmartphoneNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Smartphone not found");
        } catch (CasaProduttriceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Casa Produttrice not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}