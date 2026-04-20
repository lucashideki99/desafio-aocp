/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movimentacao.dao;

import com.lucas.desafio.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import movimentacao.model.Movimentacao;

/**
 *
 * @author lucas
 */
public class MovimentacaoDAO {

    public List<Movimentacao> listar() throws Exception {

        List<Movimentacao> lista = new ArrayList<>();

        String sql = "SELECT id, conta_origem_id, conta_destino_id, valor,  data_hora, observacao  FROM Movimentacao ORDER BY data_hora DESC";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Movimentacao t = new Movimentacao();
                t.setId(rs.getInt("id"));
                t.setContaOrigemId(rs.getInt("conta_origem_id"));
                t.setContaDestinoId(rs.getInt("conta_destino_id"));
                t.setValor(rs.getBigDecimal("valor"));
                t.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
                t.setObservacao(rs.getString("observacao"));

                lista.add(t);
            }
        }

        return lista;
    }

    public void salvar(Connection conn, Movimentacao t) throws Exception {

        String sql = "INSERT INTO movimentacao "
                + "(conta_origem_id, conta_destino_id, valor, tipo, data_hora, observacao) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getContaOrigemId());
            stmt.setInt(2, t.getContaDestinoId());
            stmt.setBigDecimal(3, t.getValor());
            stmt.setString(4, t.getTipo());
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(t.getDataHora()));
            stmt.setString(6, t.getObservacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public List<Movimentacao> buscarPorConta(int contaId) throws Exception {

        List<Movimentacao> lista = new ArrayList<>();

        String sql = "SELECT id, conta_origem_id, conta_destino_id, valor, tipo, observacao, data_hora FROM movimentacao "
                + "WHERE conta_origem_id = ? OR conta_destino_id = ? "
                + "ORDER BY data_hora DESC";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contaId);
            stmt.setInt(2, contaId);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    Movimentacao m = new Movimentacao();

                    m.setId(rs.getInt("id"));
                    m.setContaOrigemId(rs.getInt("conta_origem_id"));
                    m.setContaDestinoId(rs.getInt("conta_destino_id"));
                    m.setValor(rs.getBigDecimal("valor"));
                    m.setTipo(rs.getString("tipo"));
                    m.setObservacao(rs.getString("observacao"));

                    Timestamp ts = rs.getTimestamp("data_hora");
                    if (ts != null) {
                        m.setDataHora(ts.toLocalDateTime());
                    }

                    lista.add(m);
                }
            }
        }

        return lista;
    }

}
