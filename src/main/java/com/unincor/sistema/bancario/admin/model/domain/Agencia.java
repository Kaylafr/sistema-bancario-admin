/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

/**
 *
 * @author Kayla
 */
public class Agencia {
    
    private Long idAgencia;
    private String codigoAgencia;
    private String cidade;
    private String uf;
    private String logradouro;
    private String numero;
    private String cep;
    
    public Agencia() {
    }

    public Agencia(Long idAgencia, String codigoAgencia, String cidade, String uf, String logradouro, String numero, String cep) {
        this.idAgencia = idAgencia;
        this.codigoAgencia = codigoAgencia;
        this.cidade = cidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    public long getIdAgencia() {
        return idAgencia;
    }

    public String getCodigoAgencia() {
        return codigoAgencia;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public void setIdAgencia(Long idAgencia) {
        this.idAgencia = idAgencia;
    }

    public void setCodigoAgencia(String codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
    
            
    
    
    
}
