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