package com.unincor.sistema.bancario.admin.model.services;
/**
 *
 * @author Kayla
 */

import com.unincor.sistema.bancario.admin.model.dao.FuncionarioDao;
import com.unincor.sistema.bancario.admin.model.domain.Funcionario;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioService {

    private FuncionarioDao funcionarioDao;

    public FuncionarioService() {
        this.funcionarioDao = new FuncionarioDao();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        try {
            funcionarioDao.inserirFuncionario(funcionario);
            System.out.println("Funcionário cadastrado com sucesso.");
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, "Erro ao cadastrar funcionário", ex);
        }
    }

    public List<Funcionario> listarTodosFuncionarios() {
        try {
            return funcionarioDao.listarTodosFuncionarios();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, "Erro ao listar funcionários", ex);
            return null;
        }
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        try {
            return funcionarioDao.buscarFuncionarioPorId(id);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, "Erro ao buscar funcionário por ID", ex);
            return null;
        }
    }

    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        try {
            return funcionarioDao.buscarFuncionarioPorCpf(cpf);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, "Erro ao buscar funcionário por CPF", ex);
            return null;
        }
    }
}