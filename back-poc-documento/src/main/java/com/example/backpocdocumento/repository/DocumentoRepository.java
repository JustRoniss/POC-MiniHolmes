package com.example.backpocdocumento.repository;

import com.example.backpocdocumento.models.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
