package com.example.backpocdocumento.controllers;

import com.example.backpocdocumento.models.Fornecedor;
import com.example.backpocdocumento.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RestController

public class FornecedorController {

        private final FornecedorRepository fornecedorRepository;

        @Autowired
        public FornecedorController(FornecedorRepository fornecedorRepository){
            this.fornecedorRepository = fornecedorRepository;
        }

        @PostMapping("/adicionar-fornecedor")
        public ResponseEntity<?> criarFornecedor(@RequestBody Fornecedor fornecedor, BindingResult result){

            Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
            return ResponseEntity.ok(novoFornecedor);
        }

}
