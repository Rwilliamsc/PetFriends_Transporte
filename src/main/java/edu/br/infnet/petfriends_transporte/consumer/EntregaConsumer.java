package edu.br.infnet.petfriends_transporte.consumer;

import edu.br.infnet.petfriends_transporte.dto.PedidoEventoDto;
import edu.br.infnet.petfriends_transporte.service.EntregaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntregaConsumer {

    @Autowired
    private EntregaService entregaService;

    @RabbitListener(queues = "${broker.queue.pedido.name}")
    public void processarEventoPedido(PedidoEventoDto pedidoEvento) {
         entregaService.processarEntrega(pedidoEvento);
    }
}
