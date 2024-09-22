package edu.br.infnet.petfriends_transporte.service;

import edu.br.infnet.petfriends_transporte.dto.PedidoEventoDto;
import edu.br.infnet.petfriends_transporte.model.Entrega;
import edu.br.infnet.petfriends_transporte.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    public void processarEntrega(PedidoEventoDto pedidoEventoDto) {
        Entrega novaEntrega = new Entrega(
                pedidoEventoDto.getPedidoId(),
                "Pendente",
                LocalDateTime.now(),
               pedidoEventoDto.getEndereco()
        );

        entregaRepository.save(novaEntrega);

        System.out.println("Entrega criada e salva para o pedido: " + pedidoEventoDto.getPedidoId());
    }

    public List<Entrega> getAll() {
        return entregaRepository.findAll();
    }

    public List<Entrega> findByPedidoId(Long id) {
        return entregaRepository.findByPedidoId(id);
    }

    public List<Entrega> findByStatus(String status) {
        return entregaRepository.findByStatus(status);
    }
}
