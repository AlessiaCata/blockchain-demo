package com.ucc.demo.service;

import com.ucc.demo.model.Contrato;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ContratoService {
    private final Map<Long, Contrato> contratos = new HashMap<>();
    private Long idCounter = 1L;

    public Contrato crearContrato(String comprador, String vendedor) {
        Contrato contrato = new Contrato(idCounter++, comprador, vendedor);
        contratos.put(contrato.getId(), contrato);
        System.out.println("📄 Contrato creado: ID=" + contrato.getId() + ", Comprador=" + comprador + ", Vendedor=" + vendedor);
        return contrato;
    }

    public Contrato confirmarEntrega(Long id) {
        Contrato contrato = obtenerContrato(id);
        String estado = contrato.getEstado();

        if ("PAGADO".equals(estado)) {
            contrato.setEstado("ENTREGADO");
            System.out.println("📦 Contrato ID " + id + " marcado como ENTREGADO.");
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Solo se puede confirmar entrega si el contrato ya fue PAGADO.");
        }

        return contrato;
    }

    public Contrato iniciarDisputa(Long id) {
        Contrato contrato = obtenerContrato(id);
        if ("PENDIENTE".equals(contrato.getEstado())) {
            contrato.setEstado("EN_DISPUTA");
            System.out.println("⚠️ Disputa iniciada para contrato ID: " + id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Solo se puede iniciar disputa si el contrato está en estado PENDIENTE.");
        }
        return contrato;
    }

    public Contrato simularPago(Long id) {
        Contrato contrato = obtenerContrato(id);
        if ("PENDIENTE".equals(contrato.getEstado())) {
            contrato.setEstado("PAGADO");
            System.out.println("💰 Contrato ID " + id + " marcado como PAGADO.");
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Solo se puede pagar un contrato en estado PENDIENTE.");
        }
        return contrato;
    }

    public Contrato obtenerContrato(Long id) {
        Contrato contrato = contratos.get(id);
        if (contrato == null) {
            System.out.println("❌ Contrato no encontrado con ID: " + id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrato no encontrado");
        }
        return contrato;
    }

    public List<Contrato> obtenerTodos() {
        return new ArrayList<>(contratos.values());
    }
}
