<%@ page contentType="text/html;charset=UTF-8"  %>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">

        <a class="navbar-brand" href="/desafio/">💰 Finance Control</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menu">

            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link" href="/desafio/contaServlet?action=listar">Contas</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/desafio/movimentacaoServlet?action=listar">Transferência</a>
                </li>

            </ul>

        </div>

    </div>
</nav>