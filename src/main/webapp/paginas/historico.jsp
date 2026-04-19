<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Histórico de Transferências</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>

        <jsp:include page="/header.jsp" />

        <div class="container mt-4">

            <h2>📊 Histórico de Transferências</h2>
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


                </tbody>
            </table>

        </div>
        
        
        <jsp:include page="/footer.jsp" />
    </body>
</html>