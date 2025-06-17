/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.bancario.admin.model.dao;
/**
 *
 * @author Kayla
 */

import com.unincor.sistema.bancario.admin.configurations.MySQL;
import com.unincor.sistema.bancario.admin.model.domain.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kayla
 */

public class ClienteDao {

    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes(cpf, nome, data_nascimento, email, telefone, senha_hash) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getSenhaHash());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> listarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(construirClienteSql(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public Cliente buscarClientePorId(Long id) {
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirClienteSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Cliente construirClienteSql(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getLong("id_cliente"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setNome(rs.getString("nome"));
        cliente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        cliente.setEmail(rs.getString("email"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setSenhaHash(rs.getString("senha_hash"));
        return cliente;
    }

    public static void main(String[] args) {
        ClienteDao dao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCpf("12345678900");
        cliente.setNome("Denir Galdino Levy");
        cliente.setDataNascimento(LocalDate.of(1959, 10, 12));
        cliente.setEmail("denirGaldino@email.com");
        cliente.setTelefone("999999999999");
        cliente.setSenhaHash("123456");
        dao.inserirCliente(cliente);

        List<Cliente> lista = dao.listarTodosClientes();
        lista.forEach(c -> System.out.println("Cliente: " + c.getNome()));
    }
}

