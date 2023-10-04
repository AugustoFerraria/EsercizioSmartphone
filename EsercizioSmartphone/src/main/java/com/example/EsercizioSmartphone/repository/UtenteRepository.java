package com.example.EsercizioSmartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EsercizioSmartphone.entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
