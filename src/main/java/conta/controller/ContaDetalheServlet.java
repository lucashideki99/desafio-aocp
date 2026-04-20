/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package conta.controller;

import conta.model.Conta;
import conta.service.ContaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
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

            String json = "{"
                    + "\"id\":" + conta.getId() + ","
                    + "\"nome\":\"" + conta.getNomeTitular() + "\","
                    + "\"numero\":" + conta.getNumeroConta() + ","
                    + "\"saldo\":" + conta.getSaldo() + ","
                    + "\"status\":\"" + conta.getStatus() + "\""
                    + "}";

            resp.getWriter().write(json);

        } catch (Exception e) {
            resp.getWriter().write("{\"error\":\"erro\"}");
        }
    }
}
