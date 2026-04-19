<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Gerenciamento de Contas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>

        <jsp:include page="/header.jsp" />

        <div class="container mt-4">

            <h2>🏦 Gerenciamento de Contas</h2>
            <hr>

            <!-- FORM CADASTRO -->
            <div class="card p-3 mb-4">
                <h5>Criar nova conta</h5>

                <form action="contaServlet" method="post">

                    <input type="hidden" name="action" value="salvar">

                    <div class="row">
                        <div class="col-md-4">
                            <label>Nome titular</label>
                            <input type="text" name="nomeTitular" class="form-control" required>
                        </div>

                        <div class="col-md-4">
                            <label>Número da conta</label>
                            <input type="text" name="numeroConta" class="form-control" required>
                        </div>

                        <div class="col-md-4">
                            <label>Saldo inicial</label>
                            <input type="number" step="0.01" name="saldo" class="form-control" required>
                        </div>
                    </div>

                    <button class="btn btn-primary mt-3">Salvar</button>
                </form>
            </div>

            <!-- LISTA -->
            <h5>📋 Contas cadastradas</h5>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Titular</th>
                        <th>Número</th>
                        <th>Saldo</th>
                        <th>Status</th>
                        <th>Ações</th>
                    </tr>
                </thead>

                <tbody>
                   
                </tbody>
            </table>

        </div>
        
        <jsp:include page="/footer.jsp" />
        
    </body>
</html>