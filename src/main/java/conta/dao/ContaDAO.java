/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta.dao;

import com.lucas.desafio.util.Conexao;
import conta.model.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ContaDAO {

    public boolean salvar(Conta conta) throws Exception {

        String sql = "INSERT INTO conta (nome_titular, numero_conta, saldo, status, data_criacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNomeTitular());
            stmt.setInt(2, conta.getNumeroConta());
            stmt.setBigDecimal(3, conta.getSaldo());
            stmt.setString(4, conta.getStatus());
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(conta.getDataCriacao()));

            return stmt.executeUpdate() > 0;
        }
    }

    public List<Conta> listar() throws Exception {

        List<Conta> lista = new ArrayList<>();

        String sql = "SELECT id, nome_titular, numero_conta, saldo, status FROM conta";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Conta conta = new Conta();

                conta.setId(rs.getInt("id"));
                conta.setNomeTitular(rs.getString("nome_titular"));
                conta.setNumeroConta(rs.getInt("numero_conta"));
                conta.setSaldo(rs.getBigDecimal("saldo"));
                conta.setStatus(rs.getString("status"));

                lista.add(conta);
            }
        }

        return lista;
    }

}
