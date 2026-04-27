package com.multigacha.intercambio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterClienteDTO {
    private Integer id;
    private ClienteDTO clienteId;
    private IntercambioDTO intercambioId;
}
