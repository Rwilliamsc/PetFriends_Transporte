package edu.br.infnet.petfriends_transporte.controller;

import edu.br.infnet.petfriends_transporte.model.Entrega;
import edu.br.infnet.petfriends_transporte.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public ResponseEntity<List<Entrega>> getAllEntregas() {
        List<Entrega> entregas = entregaService.getAll();
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<List<Entrega>> getEntregasPorPedidoId(@PathVariable Long id) {
        List<Entrega> entregas = entregaService.findByPedidoId(id);
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Entrega>> getEntregasPorStatus(@PathVariable String status) {
        List<Entrega> entregas = entregaService.findByStatus(status);
        return ResponseEntity.ok(entregas);
    }
}
