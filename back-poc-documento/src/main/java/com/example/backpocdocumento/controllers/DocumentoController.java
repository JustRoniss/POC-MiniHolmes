package com.example.backpocdocumento.controllers;

import com.example.backpocdocumento.exceptions.CustomException;
import com.example.backpocdocumento.models.Documento;
import com.example.backpocdocumento.models.Fornecedor;
import com.example.backpocdocumento.repository.DocumentoRepository;
import com.example.backpocdocumento.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
public class DocumentoController {

    private final DocumentoRepository documentoRepository;
    private final FornecedorRepository fornecedorRepository;


    @Autowired
    public DocumentoController(DocumentoRepository documentoRepository, FornecedorRepository fornecedorRepository){
        this.documentoRepository = documentoRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    @PostMapping("/documento/adicionar")
    public ResponseEntity<?> criarDocumento(@RequestBody @Validated Documento documento){
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById (documento.getFornecedorId());
        if(fornecedorOptional == null)
            new CustomException("Erro ao encontrar o fornecedor pelo ID");

            Documento novoDocumento = documentoRepository.save(documento);
            return ResponseEntity.ok("Documento Criado com sucesso");
    }

    @PutMapping("/documento/atualizar")
    public ResponseEntity<?> atualizarDocumento(@RequestBody @Validated Documento documentoAtualizado){
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById (documentoAtualizado.getFornecedorId());
        if(fornecedorOptional == null)
            new CustomException("Erro ao encontrar o fornecedor pelo ID");

        Documento documentoExistente = documentoRepository.findById(documentoAtualizado.getId())
                .orElseThrow(() -> new CustomException("Documento não encontrado pelo ID"));

        documentoExistente = documentoRepository.save(documentoAtualizado);
        return ResponseEntity.ok("Documento atualizado com sucesso!");
    }


}
