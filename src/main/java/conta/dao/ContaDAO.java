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

    public boolean atualizar(Conta conta) throws Exception {

        String sql = "UPDATE conta SET "
                + "nome_titular = ?, "
                + "numero_conta = ?, "
                + "saldo = ?, "
                + "status = ? "
                + "WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNomeTitular());
            stmt.setInt(2, conta.getNumeroConta());
            stmt.setBigDecimal(3, conta.getSaldo());
            stmt.setString(4, conta.getStatus());
            stmt.setInt(5, conta.getId());

            return stmt.executeUpdate() > 0;
        }
    }

    public void atualizaStatus(int id, String atualizaStatus) throws Exception {
        String acao = null;

        if (atualizaStatus.equals("desativar")) {
            acao = "INATIVA";
        }

        if (atualizaStatus.equals("ativar")) {
            acao = "ATIVA";
        }

        if (acao == null) {
            return;
        }

        String sql = "UPDATE conta SET status = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, acao);
            stmt.setInt(2, id);

            stmt.executeUpdate();
        }
    }

    public Conta buscarPorNumeroConta(Connection conn, Integer numeroConta) throws Exception {

        String sql = "SELECT id, nome_titular, numero_conta, saldo, status FROM conta WHERE numero_conta = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroConta);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    Conta c = new Conta();
                    c.setId(rs.getInt("id"));
                    c.setNomeTitular(rs.getString("nome_titular"));
                    c.setNumeroConta(rs.getInt("numero_conta"));
                    c.setSaldo(rs.getBigDecimal("saldo"));
                    c.setStatus(rs.getString("status"));
                    return c;
                }
            }
        }

        return null;
    }

    public void atualizarSaldo(Connection conn, Conta conta) throws Exception {

        String sql = "UPDATE conta SET saldo = ? WHERE numero_conta = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBigDecimal(1, conta.getSaldo());
            stmt.setInt(2, conta.getNumeroConta());

            stmt.executeUpdate();
        }
    }

}
