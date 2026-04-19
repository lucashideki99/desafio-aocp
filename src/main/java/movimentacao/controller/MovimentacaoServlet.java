package movimentacao.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import movimentacao.service.MovimentacaoService;

/**
 *
 * @author lucas
 */
@WebServlet("/movimentacaoServlet")
public class MovimentacaoServlet extends HttpServlet {

    private MovimentacaoService service = new MovimentacaoService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
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

                service.transferir(origem, destino, valor, obs);

                resp.sendRedirect("transferencia.jsp?sucesso=true");

            } catch (Exception e) {
                e.printStackTrace();
                resp.sendRedirect("transferencia.jsp?erro=true");
            }
        }
    }

}
