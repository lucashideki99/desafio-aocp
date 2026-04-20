package movimentacao.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.math.BigDecimal;
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
@WebServlet("/movimentacaoServlet")
public class MovimentacaoServlet extends HttpServlet {

    private MovimentacaoService movimentacaoService = new MovimentacaoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("listar".equals(action) || action == null) {
            listar(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("transferir".equals(action)) {
            try {

                int origem = Integer.parseInt(req.getParameter("contaOrigem"));
                int destino = Integer.parseInt(req.getParameter("contaDestino"));
                BigDecimal valor = new BigDecimal(req.getParameter("valor"));
                String obs = req.getParameter("observacao");

                movimentacaoService.transferir(origem, destino, valor, obs);

                resp.sendRedirect("movimentacaoServlet");

            } catch (Exception e) {
                e.printStackTrace();
                resp.sendRedirect("movimentacaoServlet");
            }
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("movimentacao", movimentacaoService.listar());
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("movimentacaoServlet?action=listar");
        }

        req.getRequestDispatcher("/paginas/movimentacao.jsp").forward(req, resp);
    }

}
