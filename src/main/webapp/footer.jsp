<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String appName = application.getInitParameter("app.name");
    String appVersion = application.getInitParameter("app.version");
%>



<footer class="text-center p-3 bg-light border-top fixed-bottom">

    <div>
        <strong>Aplicação:</strong> <%= appName %>
    </div>

    <div>
        <strong>Versão:</strong> <%= appVersion %>
    </div>

</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>