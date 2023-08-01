package com.example.backpocdocumento.models;


import com.example.backpocdocumento.models.enums.TipoAutenticacao;
import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;

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


    public static String validarTipoAutenticacao(Fornecedor fornecedor){

        TipoAutenticacao tipoAutenticacao = fornecedor.getTipoAutenticacao();
        if(tipoAutenticacao == tipoAutenticacao.HEADER && fornecedor.getHeaderValue() == null){
            return "Erro: headerValue é obrigatório quando tipoAutenticao é HEADER";
        }else if(tipoAutenticacao == tipoAutenticacao.USUARIO && fornecedor.getUsuario() == null && fornecedor.getSenha() == null){
            return "Erro: usuario e senha é obrigatório quando tipoAutenticacao é USUARIO";
        }

        return "ok";
    }

}
