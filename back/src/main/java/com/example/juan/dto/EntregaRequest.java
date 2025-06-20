package com.example.juan.dto;

import lombok.Data;

@Data
public class EntregaRequest {
    private String clienteId;
    private String estado;
    private String fechaEntrega;
}
