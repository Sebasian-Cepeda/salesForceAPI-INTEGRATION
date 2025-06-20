package com.example.juan.controller;

import com.example.juan.service.ClienteService;
import com.example.juan.dto.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Crear Clientes
    @PostMapping("/cliente")
    public ResponseEntity<?> crearCliente(@RequestBody ClienteRequest cliente) {
        String result = clienteService.crearCliente(cliente);
        return ResponseEntity.ok(result);
    }

    // Consultar Clientes
    @GetMapping
    public ResponseEntity<?> consultarClientes() {
        String result = clienteService.consultarClientes();
        return ResponseEntity.ok(result);
    }
}