package com.example.EsercizioSmartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EsercizioSmartphone.entity.Smartphone;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
