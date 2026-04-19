/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movimentacao.model;

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
public class Movimentacao {
    
    private Integer id;
    private Integer contaOrigemId;
    private Integer contaDestinoId;
    private BigDecimal valor;
    private String tipo;
    private LocalDateTime dataTransferencia;
    private String observacao;
}
