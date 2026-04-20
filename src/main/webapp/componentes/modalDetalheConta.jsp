<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="modal fade" id="modalDetalheConta" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <!-- HEADER -->
            <div class="modal-header">
                <h5 class="modal-title">📄 Detalhes da Conta</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- BODY -->
            <div class="modal-body">

                <!-- DADOS DA CONTA -->
                <div class="card p-3 mb-3">
                    <h6>🏦 Informações da Conta</h6>

                    <p><b>ID:</b> <span id="detalheId"></span></p>
                    <p><b>Titular:</b> <span id="detalheNome"></span></p>
                    <p><b>Número:</b> <span id="detalheNumero"></span></p>
                    <p><b>Saldo:</b> <span id="detalheSaldo"></span></p>
                    <p><b>Status:</b> <span id="detalheStatus"></span></p>
                </div>

                <!-- HISTÓRICO DE MOVIMENTAÇÕES -->
                <div class="card p-3">
                    <h6>💸 Movimentações da Conta</h6>

                    <table class="table table-sm table-striped mt-2">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Tipo</th>
                                <th>Valor</th>
                                <th>Destino</th>
                                <th>Data</th>
                            </tr>
                        </thead>

                        <tbody id="listaMovimentacoesConta">
                            <!-- preenchido via JS ou backend -->
                            <tr>
                                <td colspan="5" class="text-center text-muted">
                                    Selecione uma conta para ver movimentações
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>

            </div>

            <!-- FOOTER -->
            <div class="modal-footer">
                <button class="btn btn-secondary" data-bs-dismiss="modal">
                    Fechar
                </button>
            </div>

        </div>
    </div>
</div>