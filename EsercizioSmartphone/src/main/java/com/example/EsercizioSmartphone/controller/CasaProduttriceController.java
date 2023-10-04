package com.example.EsercizioSmartphone.controller;

import java.util.List;

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

import com.example.EsercizioSmartphone.DTO.CasaProduttriceDTO;
import com.example.EsercizioSmartphone.Mapper.CasaProduttriceMapper;
import com.example.EsercizioSmartphone.entity.CasaProduttrice;
import com.example.EsercizioSmartphone.service.CasaProduttriceService;

@RestController
@RequestMapping("/api/casaproduttrice")
public class CasaProduttriceController {
    @Autowired
    private CasaProduttriceService casaProduttriceService;
    @Autowired CasaProduttriceMapper casaProduttriceMapper;

    @PostMapping
    public ResponseEntity<CasaProduttrice> createCasaProduttrice(@RequestBody CasaProduttrice casaProduttrice) {
        CasaProduttrice savedCasaProduttrice = casaProduttriceService.saveCasaProduttrice(casaProduttrice);
        return new ResponseEntity<>(savedCasaProduttrice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaProduttriceDTO> getCasaProduttriceById(@PathVariable("id") int id) {
        CasaProduttrice casaProduttrice = casaProduttriceService.getCasaProduttriceById(id);
        CasaProduttriceDTO casaProduttriceDTO = casaProduttriceMapper.toDTO(casaProduttrice);
        return new ResponseEntity<>(casaProduttriceDTO, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CasaProduttriceDTO>> getAllCasaProduttrici() {
        List<CasaProduttriceDTO> casaProduttriceDTOList = casaProduttriceService.getAllCasaProduttrici();
        return new ResponseEntity<>(casaProduttriceDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCasaProduttrice(@PathVariable("id") int id) {
        casaProduttriceService.deleteCasaProduttrice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
