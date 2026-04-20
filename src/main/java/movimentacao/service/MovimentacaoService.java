/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movimentacao.service;

import com.lucas.desafio.util.Conexao;
import conta.dao.ContaDAO;
import conta.model.Conta;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;
import movimentacao.dao.MovimentacaoDAO;
import movimentacao.model.Movimentacao;

/**
 *
 * @author lucas
 */
public class MovimentacaoService {

    private ContaDAO contaDAO = new ContaDAO();
    private MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

    public void transferir(int origemId, int destinoId, BigDecimal valor, String obs) throws Exception {

        Connection conn = null;

        try {
            conn = Conexao.getConnection();
            conn.setAutoCommit(false);

            Conta origem = contaDAO.buscarPorNumeroConta(conn, origemId);
            Conta destino = contaDAO.buscarPorNumeroConta(conn, destinoId);

            if (origem == null || destino == null) {
                throw new Exception("Conta não encontrada");
            }

            if (origem.getSaldo().compareTo(valor) < 0) {
                throw new Exception("Saldo insuficiente");
            }

            // débita na conta origem
            origem.setSaldo(origem.getSaldo().subtract(valor));
            contaDAO.atualizarSaldo(conn, origem);

            // crédita na conta destino
            destino.setSaldo(destino.getSaldo().add(valor));
            contaDAO.atualizarSaldo(conn, destino);

            // REGISTRA TRANSFERÊNCIA
            Movimentacao t = new Movimentacao();
            t.setContaOrigemId(origemId);
            t.setContaDestinoId(destinoId);
            t.setValor(valor);
            t.setTipo("Transferencia");
            t.setObservacao(obs);
            t.setDataHora(LocalDateTime.now());

            movimentacaoDAO.salvar(conn, t);

            conn.commit();

        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public List<Movimentacao> buscarPorConta(Integer id) throws Exception {
        return movimentacaoDAO.buscarPorConta(id);
    }

    public List<Movimentacao> listar() throws Exception {
        return movimentacaoDAO.listar();
    }

}
