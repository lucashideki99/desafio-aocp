<div class="modal fade" id="modalAdicionar">
    <div class="modal-dialog">
        <div class="modal-content">

            <form action="contaServlet" method="post">
                <input type="hidden" name="action" value="salvar">

                <div class="modal-header">
                    <h5 class="modal-title">Nova Conta</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <div class="modal-body">
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
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary">Salvar</button>
                </div>
            </form>

        </div>
    </div>
</div>