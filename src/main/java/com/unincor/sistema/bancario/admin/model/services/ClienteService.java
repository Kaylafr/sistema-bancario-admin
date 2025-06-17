/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.services;
/**
 *
 * @author Kayla
 */

import com.unincor.sistema.bancario.admin.model.dao.ClienteDao;
import com.unincor.sistema.bancario.admin.model.domain.Cliente;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ClienteService {

    private final ClienteDao clienteDao = new ClienteDao();

    public void salvarCliente(Cliente c) throws CadastroException, SQLException {
        if (c.getNome() == null || c.getNome().isBlank()) {
            throw new CadastroException("Nome do cliente não pode estar vazio");
        }
        if (c.getCpf() == null || c.getCpf().isBlank()) {
            throw new CadastroException("CPF do cliente não pode estar vazio");
        }
        if (c.getDataNascimento() == null) {
            throw new CadastroException("Data de nascimento deve ser informada");
        }
        if (c.getEmail() == null || c.getEmail().isBlank()) {
            throw new CadastroException("E‑mail do cliente não pode estar vazio");
        }
        if (c.getTelefone() == null || c.getTelefone().isBlank()) {
            throw new CadastroException("Telefone do cliente não pode estar vazio");
        }
        if (c.getSenhaHash() == null || c.getSenhaHash().isBlank()) {
            throw new CadastroException("Senha do cliente não pode estar vazia");
        }

        clienteDao.inserirCliente(c);
    }

    public Cliente buscarPorId(Long id) {
        return clienteDao.buscarClientePorId(id);
    }

    public List<Cliente> listarTodos() {
        return clienteDao.listarTodosClientes();
    }

    public static void main(String[] args) {
        ClienteService service = new ClienteService();

        Cliente c = new Cliente();
        c.setNome("Raimundo Galdino");
        c.setCpf("05468745996");
        c.setDataNascimento(LocalDate.of(1955, 4, 17));
        c.setEmail("Raimundaogaldino@email.com");
        c.setTelefone("3586987456");
        c.setSenhaHash("Raimundao123");

        try {
            service.salvarCliente(c);
            System.out.println("Cliente salvo com sucesso.");
        } catch (CadastroException | SQLException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }
}