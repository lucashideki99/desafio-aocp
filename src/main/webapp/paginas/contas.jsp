<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <th width="25%">Ações</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="conta" items="${contas}">
                        <tr>
                            <td>${conta.id}</td>
                            <td>${conta.nomeTitular}</td>
                            <td>${conta.numeroConta}</td>
                            <td>${conta.saldo}</td>
                            <td>${conta.status}</td>

                            <td>

                                <button class="btn btn-info btn-sm"
                                         onclick="abrirDetalhe('${conta.id}')"
                                         data-bs-toggle="modal"
                                         data-bs-target="#modalDetalheConta"
                                         onclick="abrirDetalhe(
                                                        '${conta.id}',
                                                        '${conta.nomeTitular}',
                                                        '${conta.numeroConta}',
                                                        '${conta.saldo}',
                                                        '${conta.status}'
                                                        )">
                                    + Informações
                                </button>

                                <!-- ATUALIZAR -->
                                <button class="btn btn-warning btn-sm"
                                        data-bs-toggle="modal"
                                        data-bs-target="#modalAdicionar"
                                        onclick="preencherEdicao(
                                                        '${conta.id}',
                                                        '${conta.nomeTitular}',
                                                        '${conta.numeroConta}',
                                                        '${conta.saldo}',
                                                        '${conta.status}'
                                                        )">
                                    Atualizar
                                </button>

                                <!-- DESATIVAR (somente ATIVA) -->
                                <c:if test="${conta.status == 'ATIVA'}">
                                    <form action="${pageContext.request.contextPath}/contaServlet"
                                          method="post"
                                          style="display:inline;">

                                        <input type="hidden" name="action" value="desativar">
                                        <input type="hidden" name="id" value="${conta.id}">

                                        <button type="submit"
                                                class="btn btn-danger btn-sm"
                                                onclick="return confirm('Deseja desativar esta conta?')">
                                            Desativar
                                        </button>
                                    </form>
                                </c:if>

                                <!-- ATIVAR (somente INATIVA) -->
                                <c:if test="${conta.status == 'INATIVA'}">
                                    <form action="${pageContext.request.contextPath}/contaServlet"
                                          method="post"
                                          style="display:inline;">

                                        <input type="hidden" name="action" value="ativar">
                                        <input type="hidden" name="id" value="${conta.id}">

                                        <button type="submit"
                                                class="btn btn-success btn-sm"
                                                onclick="return confirm('Deseja ativar esta conta?')">
                                            Ativar
                                        </button>
                                    </form>
                                </c:if>

                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
        <!-- INCLUDES DOS MODAIS -->
        <jsp:include page="/componentes/modalAdicionarConta.jsp" />
        <jsp:include page="/componentes/modalDetalheConta.jsp" /> 

        <jsp:include page="/footer.jsp" />

        <script src="${pageContext.request.contextPath}/js/contas.js"></script>
    </body>
</html>