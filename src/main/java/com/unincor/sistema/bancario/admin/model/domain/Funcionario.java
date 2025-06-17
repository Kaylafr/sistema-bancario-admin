/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.domain;

/**
 *
 * @author Kayla
 */
public class Funcionario extends Pessoa {
    private Long idFuncionario;
    private String turno;
    
    public Funcionario() {
                
    }    
        
    public Long getIdFuncionario(){
    return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }   
    
    
}
