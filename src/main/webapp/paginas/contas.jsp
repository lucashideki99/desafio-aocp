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

            <div class="d-flex justify-content-end mb-3">
                <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalAdicionar">
                    + Adicionar Conta
                </button>

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
        <!-- INCLUDES DOS MODAIS -->
        <jsp:include page="/componentes/modalAdicionarConta.jsp" />
        <jsp:include page="/componentes/modalDetalheConta.jsp" /> 

        <jsp:include page="/footer.jsp" />

        <script>
            function abrirDetalhe(id, nome, numero, saldo, status) {
                document.getElementById("detalheId").innerText = id;
                document.getElementById("detalheNome").innerText = nome;
                document.getElementById("detalheNumero").innerText = numero;
                document.getElementById("detalheSaldo").innerText = saldo;
                document.getElementById("detalheStatus").innerText = status;
            }
        </script>


    </body>
</html>