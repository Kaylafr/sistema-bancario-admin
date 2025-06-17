/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;

import com.unincor.sistema.bancario.admin.model.dao.AgenciaDao;
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import java.util.List;

/**
 *
 * @author Kayla
 */
public class AgenciaService {

    private final AgenciaDao agenciaDao = new AgenciaDao();

    public void salvarAgencia(Agencia agencia) throws CadastroException {
        if (agencia.getCodigoAgencia() == null || agencia.getCodigoAgencia().isBlank()) {
            throw new CadastroException("A agência não possui um código de agência.");
        }

        // Criar uma validação se o código de agência já está cadastro
        if (agenciaDao.buscarAgenciaPorCodigo(agencia.getCodigoAgencia()) != null) {
            throw new CadastroException("Código da agência já está cadastrado.");
        }

        // Validar se a agencia esta com Cidade e UF preenchido
        if (agencia.getUf() == null || agencia.getUf().isBlank()) {
            throw new CadastroException("A agência não possui UF informada.");
        }

        if (agencia.getCidade() == null || agencia.getCidade().isBlank()) {
            throw new CadastroException("A agência não possui cidade informada.");
        }

        agenciaDao.inserirAgencia(agencia);
    }
    public List<Agencia> buscarAgencia(){
    return agenciaDao.listarTodasAgencias();
}
        
    public static void main(String[] args) {
        AgenciaService agenciaService = new AgenciaService();

        Agencia agencia = new Agencia();
        agencia.setCodigoAgencia("1234");
        agencia.setUf("MG");
        agencia.setCidade("Três Corações");

        try {
            agenciaService.salvarAgencia(agencia);
            System.out.println("Agência salva com sucesso.");
        } catch (CadastroException e) {
            System.out.println("Erro ao salvar agência: " + e.getMessage());
        }
    }
}