package com.example.backpocdocumento.models;


import com.example.backpocdocumento.models.enums.TipoAutenticacao;
import jakarta.persistence.*;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sistemaOrigem;

    @Column(nullable = false)
    private String urlDeConexao;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoAutenticacao tipoAutenticacao;


    public String getSistemaOrigem() {
        return sistemaOrigem;
    }

    public void setSistemaOrigem(String sistemaOrigem) {
        this.sistemaOrigem = sistemaOrigem;
    }

    public String getUrlDeConexao() {
        return urlDeConexao;
    }

    public void setUrlDeConexao(String urlDeConexao) {
        this.urlDeConexao = urlDeConexao;
    }

    public TipoAutenticacao getTipoAutenticacao() {
        return tipoAutenticacao;
    }

    public void setTipoAutenticacao(TipoAutenticacao tipoAutenticcao) {
        this.tipoAutenticacao = tipoAutenticcao;
    }



}
