/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta.dao;

import com.lucas.desafio.util.conexao;
import conta.model.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lucas
 */
public class ContaDAO {

    public boolean salvar(Conta conta) throws Exception {

        String sql = "INSERT INTO conta (nome_titular, numero_conta, saldo, status, data_criacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNomeTitular());
            stmt.setInt(2, conta.getNumeroConta());
            stmt.setBigDecimal(3, conta.getSaldo());
            stmt.setString(4, conta.getStatus());
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(conta.getDataCriacao()));

            return stmt.executeUpdate() > 0;
        }
    }
}
