package com.GreenEnergy.registroClientes.controller;

import com.GreenEnergy.registroClientes.DTO.ClienteRegistroDto;
import com.GreenEnergy.registroClientes.DTO.UsuarioDto;
import com.GreenEnergy.registroClientes.service.ClienteRegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteRegistroController {

    @Autowired
    private ClienteRegistroService clienteRegistroService;

    @PostMapping
    public ResponseEntity<UsuarioDto> registrarCliente(@RequestBody ClienteRegistroDto dto) {
        UsuarioDto creado = clienteRegistroService.registrarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    
}