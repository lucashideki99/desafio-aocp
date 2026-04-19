/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movimentacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import movimentacao.model.Movimentacao;

/**
 *
 * @author lucas
 */
public class MovimentacaoDAO {

    public void salvar(Connection conn, Movimentacao t) throws Exception {

        String sql = "INSERT INTO movimentacao "
                + "(conta_origem_id, conta_destino_id, valor, tipo, data_hora, observacao) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, t.getContaOrigemId());
            stmt.setInt(2, t.getContaDestinoId());
            stmt.setBigDecimal(3, t.getValor());
            stmt.setString(4, t.getTipo());
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(t.getDataTransferencia()));
            stmt.setString(6, t.getObservacao());

            stmt.executeUpdate();
        }
    }


}
