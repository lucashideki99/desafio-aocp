document.addEventListener("DOMContentLoaded", function () {

    const modalAdicionar = document.getElementById('modalAdicionar');

    if (modalAdicionar) {
        modalAdicionar.addEventListener('hidden.bs.modal', function () {
            const form = document.getElementById('formAdicionarConta');
            if (form) {
                form.reset();
            }
        });
    }

});

function preencherEdicao(id, nome, numero, saldo, status) {

    document.getElementById("id").value = id;
    document.getElementById("nomeTitular").value = nome;
    document.getElementById("numeroConta").value = numero;
    document.getElementById("saldo").value = saldo;
    document.getElementById("status").value = status;
    
    document.getElementById("action").value = "atualizar";
    
    const btnSalvar = document.getElementById("btnSalvar");
    if (btnSalvar) {
        btnSalvar.innerText = "Atualizar";
    }
}

function abrirDetalhe(id) {
    const contextPath = window.location.pathname.split('/')[1];

    fetch('/' + contextPath + '/ContaDetalhamentoServlet?id=' + id)
        .then(resp => resp.json())
        .then(data => {

            document.getElementById("detalheId").innerText = data.id;
            document.getElementById("detalheNome").innerText = data.nome;
            document.getElementById("detalheNumero").innerText = data.numero;
            document.getElementById("detalheSaldo").innerText = data.saldo;
            document.getElementById("detalheStatus").innerText = data.status;

        })
        .catch(err => console.log("Erro:", err));
}