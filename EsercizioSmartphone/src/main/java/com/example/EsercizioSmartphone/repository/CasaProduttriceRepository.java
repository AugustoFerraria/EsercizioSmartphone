package com.example.EsercizioSmartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EsercizioSmartphone.entity.CasaProduttrice;

@Repository
public interface CasaProduttriceRepository extends JpaRepository<CasaProduttrice, Integer> {

}
