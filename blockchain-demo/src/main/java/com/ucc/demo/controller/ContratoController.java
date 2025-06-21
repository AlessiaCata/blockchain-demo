package com.ucc.demo.controller;

import com.ucc.demo.model.Contrato;
import com.ucc.demo.service.ContratoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<Contrato> crearContrato(@RequestBody Contrato contrato) {
        Contrato nuevo = contratoService.crearContrato(contrato.getComprador(), contrato.getVendedor());
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Contrato> obtenerTodos() {
        return contratoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerContrato(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.obtenerContrato(id);
            return ResponseEntity.ok(contrato);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrato no encontrado con ID: " + id);
        }
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<?> confirmarEntrega(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.confirmarEntrega(id);
            return ResponseEntity.ok(contrato);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al confirmar entrega: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/disputa")
    public ResponseEntity<?> iniciarDisputa(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.iniciarDisputa(id);
            return ResponseEntity.ok(contrato);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al iniciar disputa: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/pagar")
    public ResponseEntity<?> simularPago(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.simularPago(id);
            return ResponseEntity.ok(contrato);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al simular pago: " + e.getMessage());
        }
    }
}
