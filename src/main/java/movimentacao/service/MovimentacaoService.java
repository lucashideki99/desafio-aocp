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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import movimentacao.dao.MovimentacaoDAO;
import movimentacao.model.Movimentacao;

/**
 *
 * @author lucas
 */
public class MovimentacaoService {

    private ContaDAO contaDAO = new ContaDAO();
    private MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();

    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, BigDecimal valorTranferencia, String obs) throws Exception {

        Connection conn = null;

        try {
            conn = Conexao.getConnection();
            conn.setAutoCommit(false);

            Conta ContaOrigem = contaDAO.buscarPorNumeroConta(conn, numeroContaOrigem);
            Conta contaDestino = contaDAO.buscarPorNumeroConta(conn, numeroContaDestino);

            if (!validaConta(ContaOrigem, contaDestino, valorTranferencia)) {
                return false;
            }

            // débita na conta origem
            ContaOrigem.setSaldo(ContaOrigem.getSaldo().subtract(valorTranferencia));
            contaDAO.atualizarSaldo(conn, ContaOrigem);

            // crédita na conta destino
            contaDestino.setSaldo(contaDestino.getSaldo().add(valorTranferencia));
            contaDAO.atualizarSaldo(conn, contaDestino);

            // REGISTRA TRANSFERÊNCIA
            Movimentacao t = new Movimentacao();
            t.setContaOrigemId(ContaOrigem.getId());
            t.setContaDestinoId(contaDestino.getId());
            t.setValor(valorTranferencia);
            t.setTipo("Transferencia");
            t.setObservacao(obs);
            t.setDataHora(LocalDateTime.now());

            movimentacaoDAO.salvar(conn, t);

            conn.commit();
            return true;
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean validaConta(Conta contaOrigem, Conta contaDestino, BigDecimal valorTranferencia) {
        
        if(Objects.equals(contaOrigem.getId(), contaDestino.getId())){
            return false;
        }
        
        if (contaOrigem == null || contaDestino == null) {
            return false;
        }

        if (contaOrigem.getSaldo().compareTo(valorTranferencia) < 0) {
            return false;
        }
        
        if (!contaOrigem.getStatus().equals("ATIVA") || !contaDestino.getStatus().equals("ATIVA"))  {
            return false;
        }
        
        return true;
    }

    public List<Movimentacao> buscarPorConta(Integer id) throws Exception {
        return movimentacaoDAO.buscarPorConta(id);
    }

    public List<Movimentacao> listar() throws Exception {
        return movimentacaoDAO.listar();
    }

}
