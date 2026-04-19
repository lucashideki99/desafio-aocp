/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta.service;

import conta.dao.ContaDAO;
import conta.model.Conta;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ContaService {
    
    private ContaDAO contaDAO = new ContaDAO();
    
    public boolean salvar(Conta conta) throws Exception {
        if(!validaCampos(conta)){
            return false;
        }
        
        conta.setStatus(conta.getStatus() != null ? conta.getStatus() : "ATIVA");
        conta.setDataCriacao(LocalDateTime.now());
        
        return contaDAO.salvar(conta);
    }
    
    public List<Conta> listar() throws Exception {
        return contaDAO.listar();
    }
    
    
    private boolean validaCampos(Conta conta) throws Exception{
        List<Conta> contas = contaDAO.listar();
        
        if (conta.getNomeTitular() == null || conta.getNomeTitular().isEmpty()) {
            return false;
        }

        if (conta.getNumeroConta() <= 0 && conta.getNumeroConta() > 999999) {
            return false;
        }

        if (conta.getSaldo() == null) {
            return false;
        }

        if (conta.getSaldo().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        for (Conta c : contas) {
            if (c.getNumeroConta().equals(conta.getNumeroConta())) {
                return false;
            }
        }
        return true;
    }
    
}
