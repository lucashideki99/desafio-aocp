/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package conta.controller;

import conta.model.Conta;
import conta.service.ContaService;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet("/contaServlet")
public class ContasServlet extends HttpServlet {

    private ContaService contaService = new ContaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "listar":
                listar(req, resp);
                break;
            default:
                listar(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("salvar".equals(action)) {
            try {
                salvar(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("contas", contaService.listar());
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/paginas/contas.jsp").forward(req, resp);
    }

    private void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, Exception {
        Conta conta = new Conta();

        conta.setNomeTitular(req.getParameter("nomeTitular"));
        conta.setNumeroConta(Integer.valueOf(req.getParameter("numeroConta")));
        conta.setSaldo(new BigDecimal(req.getParameter("saldo")));
        conta.setStatus(req.getParameter("status"));

        boolean resultado = contaService.salvar(conta);

        if (resultado) {
            resp.sendRedirect("contaServlet?action=listar");
        } 

    }

}
