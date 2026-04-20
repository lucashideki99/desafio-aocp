/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package conta.controller;

import conta.model.Conta;
import conta.service.ContaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import movimentacao.model.Movimentacao;
import movimentacao.service.MovimentacaoService;

/**
 *
 * @author lucas
 */
@WebServlet("/ContaDetalhamentoServlet")
public class ContaDetalheServlet extends HttpServlet {

    private ContaService contaService = new ContaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            Conta conta = contaService.buscarPorId(id);

            MovimentacaoService movimentacaoService = new MovimentacaoService();
            List<Movimentacao> movimentacoes = movimentacaoService.buscarPorConta(id);

            StringBuilder json = new StringBuilder();

            json.append("{")
                    .append("\"id\":").append(conta.getId()).append(",")
                    .append("\"nome\":\"").append(conta.getNomeTitular()).append("\",")
                    .append("\"numero\":").append(conta.getNumeroConta()).append(",")
                    .append("\"saldo\":").append(conta.getSaldo()).append(",")
                    .append("\"status\":\"").append(conta.getStatus()).append("\",")
                    .append("\"movimentacoes\":[");

            for (int i = 0; i < movimentacoes.size(); i++) {
                Movimentacao m = movimentacoes.get(i);

                json.append("{")
                        .append("\"id\":").append(m.getId()).append(",")
                        .append("\"tipo\":\"").append(m.getTipo()).append("\",")
                        .append("\"valor\":").append(m.getValor()).append(",")
                        .append("\"destino\":").append(m.getContaDestinoId()).append(",")
                        .append("\"data\":\"").append(m.getDataHora()).append("\"")
                        .append("}");

                if (i < movimentacoes.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]}");

            resp.getWriter().write(json.toString());

        } catch (Exception e) {
            resp.getWriter().write("{\"error\":\"erro ao buscar detalhes\"}");
        }
    }
}
