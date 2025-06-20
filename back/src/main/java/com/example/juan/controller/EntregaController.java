package com.example.juan.controller;

import com.example.juan.dto.EntregaRequest;
import com.example.juan.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    // Crear entrega
    @PostMapping("/entrega")
    public ResponseEntity<String> crearEntrega(@RequestBody EntregaRequest entregaRequest) {
        String resultado = entregaService.crearEntrega(entregaRequest);
        return ResponseEntity.ok(resultado);
    }

    // Consultar entregas por cliente
    @GetMapping("/{clienteId}")
    public ResponseEntity<String> consultarEntregasPorCliente(@PathVariable String clienteId) {
        String resultado = entregaService.consultarEntregasPorCliente(clienteId);
        return ResponseEntity.ok(resultado);
    }

    // Acrualizar estado entrega
    @PutMapping("/entrega/{id}")
    public ResponseEntity<?> actualizarEstadoEntrega(
            @PathVariable String id,
            @RequestBody EntregaRequest entrega) {
        String result = entregaService.actualizarEstadoEntrega(id, entrega);
        return ResponseEntity.ok(result);
    }

}
