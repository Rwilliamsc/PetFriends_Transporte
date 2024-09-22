package edu.br.infnet.petfriends_transporte.repository;

import edu.br.infnet.petfriends_transporte.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    List<Entrega> findByStatus(String status);
    List<Entrega> findByPedidoId(Long pedidoId);
}
