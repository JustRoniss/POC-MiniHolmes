package com.example.backpocdocumento.controllers;

import com.example.backpocdocumento.models.Fornecedor;
import com.example.backpocdocumento.models.enums.TipoAutenticacao;
import com.example.backpocdocumento.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
        public ResponseEntity<?> criarFornecedor(@RequestBody @Validated Fornecedor fornecedor, BindingResult result){

            if(fornecedor.validarTipoAutenticacao(fornecedor)){
                Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
                return ResponseEntity.ok(novoFornecedor);
            }else{
                return ResponseEntity.badRequest().body("Erro inesperado, contate o desenvolvedor");
            }

        }

//        @PutMapping("/atualizar-fornecedor")
//        public ResponseEntity<?> atualizarFornecedor(@RequestBody @Validated Fornecedor fornecedor, BindingResult result){
//
//        }

}
