<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Controle Financeiro</title>

        <style>
            body {
                background-color: #f4f6f9;
            }

            .navbar {
                margin-bottom: 30px;
            }

            .card-menu {
                transition: 0.2s;
            }

            .card-menu:hover {
                transform: scale(1.03);
                box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            }

            .container-main {
                margin-top: 50px;
            }
        </style>
    </head>

    <body>
        
        <jsp:include page="/header.jsp" />

        <!-- CONTEÚDO PRINCIPAL -->
        <div class="container container-main">

            <div class="text-center mb-5">
                <h1>Bem-vindo ao Controle Financeiro</h1>
                <p class="text-muted">Gerencie contas, transferências e histórico de movimentações</p>
            </div>

            <div class="row g-4">

                <!-- CONTAS -->
                <div class="col-md-4">
                    <a href="/desafio/contaServlet?action=listar" style="text-decoration:none;">
                        <div class="card card-menu text-center p-4">
                            <h3>🏦 Contas</h3>
                            <p>Gerenciar contas bancárias</p>
                        </div>
                    </a>
                </div>

                <!-- TRANSFERÊNCIA -->
                <div class="col-md-4">
                    <a href="/desafio/movimentacaoServlet?action=listar" style="text-decoration:none;">
                        <div class="card card-menu text-center p-4">
                            <h3>💸 Transferência</h3>
                            <p>Realizar transferências entre contas</p>
                        </div>
                    </a>
                </div>

                <!-- HISTÓRICO -->
                <div class="col-md-4">
                    <a href="/desafio/paginas/historico.jsp" style="text-decoration:none;">
                        <div class="card card-menu text-center p-4">
                            <h3>📊 Histórico</h3>
                            <p>Visualizar movimentações</p>
                        </div>
                    </a>
                </div>

            </div>

        </div>

        <jsp:include page="/footer.jsp" />

    </body>
    
</html>