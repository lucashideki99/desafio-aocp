<%@ page contentType="text/html;charset=UTF-8" %>
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

            <div class="card p-4">

                <form action="${pageContext.request.contextPath}/transferenciaServlet" method="post">

                    <input type="hidden" name="action" value="transferir">

                    <div class="row">

                        <div class="col-md-4">
                            <label>Conta origem</label>
                            <input type="text" name="contaOrigem" class="form-control" required>
                        </div>

                        <div class="col-md-4">
                            <label>Conta destino</label>
                            <input type="text" name="contaDestino" class="form-control" required>
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

        </div>
        
        <jsp:include page="/footer.jsp" />
        
    </body>
</html>