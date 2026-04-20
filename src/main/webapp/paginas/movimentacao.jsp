<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Movimentação</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>

        <jsp:include page="/header.jsp" />

        <div class="container mt-4">

            <h2>💸 Nova Movimentação</h2>
            <hr>

            <!-- FORMULÁRIO -->
            <div class="card p-4 mb-4">

                <form action="${pageContext.request.contextPath}/movimentacaoServlet" method="post">

                    <input type="hidden" name="action" value="transferir">

                    <div class="row">

                        <div class="col-md-4">
                            <label>Conta origem</label>
                            <input type="number" name="contaOrigem" class="form-control" required>
                        </div>

                        <div class="col-md-4">
                            <label>Conta destino</label>
                            <input type="number" name="contaDestino" class="form-control" required>
                        </div>

                        <div class="col-md-4">
                            <label>Valor</label>
                            <input type="number" step="0.01" name="valor" class="form-control" required>
                        </div>

                    </div>

                    <div class="mt-3">
                        <label>Observação</label>
                        <input type="text" name="observacao" class="form-control">
                    </div>

                    <button class="btn btn-success mt-3">Transferir</button>
                </form>

            </div>


            <!-- HISTÓRICO -->
            <h2>📊 Histórico de Movimentação</h2>
            <hr>

            <table class="table table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Conta Origem</th>
                        <th>Conta Destino</th>
                        <th>Valor</th>
                        <th>Tipo</th>
                        <th>Data/Hora</th>
                        <th>Observação</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach var="t" items="${movimentacao}">
                        <tr>
                            <td>${t.id}</td>
                            <td>${t.contaOrigemId}</td>
                            <td>${t.contaDestinoId}</td>
                            <td>${t.valor}</td>
                            <td>TRANSFERÊNCIA</td>
                            <td>${t.dataHoraFormatada}</td>
                            <td>${t.observacao}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>

        <jsp:include page="/footer.jsp" />

    </body>
</html>