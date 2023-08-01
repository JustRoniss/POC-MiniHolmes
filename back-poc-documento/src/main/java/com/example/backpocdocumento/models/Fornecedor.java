package com.example.backpocdocumento.models;


import com.example.backpocdocumento.exceptions.CustomException;
import com.example.backpocdocumento.models.enums.TipoAutenticacao;
import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    private String headerValue;


    private String usuario;

    private String senha;


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

    public String getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }




    public static boolean validarTipoAutenticacao(Fornecedor fornecedor){

        TipoAutenticacao tipoAutenticacao;
        tipoAutenticacao = fornecedor.getTipoAutenticacao();
        if(tipoAutenticacao == tipoAutenticacao.HEADER && fornecedor.getHeaderValue() == null)
            throw new CustomException("Erro: Quando tipo autenticação é HEADER, precisa ser enviado o headerValue junto da requisição\n" +
                    "Exemplo: 'headerValue': 'exemplo' ");

        if(tipoAutenticacao == tipoAutenticacao.USUARIO && fornecedor.getUsuario() == null && fornecedor.getSenha() == null)
            throw new CustomException("Erro: Quando tipo autenticação é USUARIO, precisa ser enviado usuario e senha junto da requisição\n" +
                    "Exemplo: 'usuario': 'ronaldo'\n 'senha': 'exemploSenha'");

        if(tipoAutenticacao == tipoAutenticacao.USUARIO && fornecedor.getUsuario() == null | fornecedor.getSenha() == null)
            throw new CustomException("Erro: Quando tipo autenticação é USUARIO, precisa ser enviado usuario e senha junto da requisição\n" +
                    "Exemplo: 'usuario': 'ronaldo'\n 'senha': 'exemploSenha'");


        return true;
    }

}
