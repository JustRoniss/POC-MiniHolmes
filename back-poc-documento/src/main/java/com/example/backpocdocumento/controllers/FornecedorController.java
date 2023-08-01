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

            TipoAutenticacao tipoAutenticacao = fornecedor.getTipoAutenticacao();

            String message = fornecedor.validarTipoAutenticacao(fornecedor);

            if(message != "Ok"){
                return ResponseEntity.badRequest().body(message);
            }
//            if(tipoAutenticacao == tipoAutenticacao.HEADER && fornecedor.getHeaderValue() == null){
//                return ResponseEntity.badRequest().body("Erro: headerValue é obrigatório quando tipoAutenticao é HEADER");
//            }

            Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
            return ResponseEntity.ok(novoFornecedor);
        }

//        @PutMapping("/atualizar-fornecedor")
//        public ResponseEntity<?> atualizarFornecedor(@RequestBody @Validated Fornecedor fornecedor, BindingResult result){
//
//        }

}
