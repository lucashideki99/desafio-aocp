/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conta.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@Getter
@Setter
@NoArgsConstructor
public class Conta {
    
    private Integer id;
    private String nomeTitular;
    private Integer numeroConta;
    private BigDecimal saldo;
    private String status;
    private LocalDateTime dataCriacao;

}
