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
import com.unincor.sistema.bancario.admin.model.domain.Agencia;
import com.unincor.sistema.bancario.admin.model.domain.Gerente;
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

public class GerenteDao {

    public void inserirGerente(Gerente gerente) {
        String sql = "INSERT INTO gerentes(cpf, nome, data_nascimento, email, telefone, senha_hash, id_agencia) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, gerente.getCpf());
            ps.setString(2, gerente.getNome());
            ps.setDate(3, Date.valueOf(gerente.getDataNascimento()));
            ps.setString(4, gerente.getEmail());
            ps.setString(5, gerente.getTelefone());
            ps.setString(6, gerente.getSenhaHash());
            ps.setLong(7, gerente.getAgencia().getIdAgencia());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Gerente> listarTodosGerentes() {
        List<Gerente> gerentes = new ArrayList<>();
        String sql = "SELECT * FROM gerentes";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gerentes.add(construirGerenteSql(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gerentes;
    }

    public Gerente buscarGerentePorId(Long id) {
        String sql = "SELECT * FROM gerentes WHERE id_gerente = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirGerenteSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Gerente construirGerenteSql(ResultSet rs) throws SQLException {
        Gerente g = new Gerente();
        g.setIdGerente(rs.getLong("id_gerente"));
        g.setCpf(rs.getString("cpf"));
        g.setNome(rs.getString("nome"));
        g.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        g.setEmail(rs.getString("email"));
        g.setTelefone(rs.getString("telefone"));
        g.setSenhaHash(rs.getString("senha_hash"));

        Agencia a = new Agencia();
        a.setIdAgencia(rs.getLong("id_agencia"));
        g.setAgencia(a);
        return g;
    }

    public static void main(String[] args) {
        GerenteDao dao = new GerenteDao();
        Gerente g = new Gerente();
        g.setCpf("11111111111");
        g.setNome("Kayla dos Reis");
        g.setDataNascimento(LocalDate.of(1975, 7, 22));
        g.setEmail("edigar@banco.com");
        g.setTelefone("34997777777");
        g.setSenhaHash("gerente123");
        Agencia a = new Agencia();
        a.setIdAgencia(1l); 
        g.setAgencia(a);
        dao.inserirGerente(g);

    }
}
