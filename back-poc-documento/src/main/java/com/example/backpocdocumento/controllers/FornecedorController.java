package com.example.backpocdocumento.controllers;

import com.example.backpocdocumento.exceptions.CustomException;
import com.example.backpocdocumento.models.Fornecedor;
import com.example.backpocdocumento.models.enums.TipoAutenticacao;
import com.example.backpocdocumento.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.crossstore.ChangeSetPersister;
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
        public ResponseEntity<?> criarFornecedor(@RequestBody @Validated Fornecedor fornecedor){

            if(fornecedor.validarTipoAutenticacao(fornecedor)){
                Fornecedor novoFornecedor = fornecedorRepository.save(fornecedor);
                return ResponseEntity.ok("Fornecedor criado com sucesso!");
            }else{
                return ResponseEntity.badRequest().body("Erro inesperado, contate o desenvolvedor");
            }

        }

        @PutMapping("/atualizar-fornecedor")
        public ResponseEntity<?> atualizarFornecedor(@RequestBody @Validated Fornecedor fornecedorAtualizado){

            if(fornecedorAtualizado.validarTipoAutenticacao(fornecedorAtualizado)){
                Fornecedor fornecedorExistente = fornecedorRepository.findById(fornecedorAtualizado.getId())
                        .orElseThrow(() -> new CustomException("Fornecedor não encontrado pelo ID"));


                fornecedorExistente.setSistemaOrigem(fornecedorAtualizado.getSistemaOrigem());
                fornecedorExistente.setUrlDeConexao(fornecedorAtualizado.getUrlDeConexao());
                fornecedorExistente.setTipoAutenticacao(fornecedorAtualizado.getTipoAutenticacao());
                fornecedorExistente.setHeaderValue(fornecedorAtualizado.getHeaderValue());
                fornecedorExistente.setUsuario(fornecedorAtualizado.getUsuario());
                fornecedorExistente.setSenha(fornecedorAtualizado.getSenha());

                fornecedorAtualizado = fornecedorRepository.save(fornecedorExistente);
            }


            return ResponseEntity.ok("Fornecedor atualizado com sucesso");

        }

        @DeleteMapping("/deletar-fornecedor")
        public ResponseEntity<?> deletarFornecedor(@RequestBody @Validated Fornecedor fornecedor){
            fornecedorRepository.findById(fornecedor.getId())
                    .orElseThrow(() -> new CustomException("Fornecedor não encontrado pelo ID"));

            fornecedorRepository.delete(fornecedor);
            return ResponseEntity.ok("Fornecedor deletado com sucesso");
        }

}
