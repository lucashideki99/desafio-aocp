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