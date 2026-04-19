<div class="modal fade" id="modalAdicionar">
    <div class="modal-dialog">
        <div class="modal-content">

            <form id="formAdicionarConta" action="${pageContext.request.contextPath}/contaServlet" method="post">
                <input type="hidden" name="action" id="action" value="salvar">

                <div class="modal-header">
                    <h5 class="modal-title">Nova Conta</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" id="id" name="id">
                    <div class="mb-3">
                        <label class="form-label">Nome do Titular</label>
                        <input type="text" id="nomeTitular" name="nomeTitular" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Número da Conta</label>
                        <input type="number" id="numeroConta" name="numeroConta" class="form-control" required min="1" max="999999" >
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Saldo Inicial</label>
                        <input type="number" step="0.01" id="saldo" name="saldo" class="form-control" required min="0">
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Status</label>
                        <select id="status" name="status" class="form-select" required>
                            <option value="ATIVA" selected>ATIVA</option>
                            <option value="INATIVA">INATIVA</option>
                        </select>
                    </div>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" id="btnSalvar" class="btn btn-primary">
                        Salvar
                    </button>
                </div>

            </form>

        </div>
    </div>
</div>
                
                