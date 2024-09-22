package edu.br.infnet.petfriends_transporte.dto;

import edu.br.infnet.petfriends_transporte.vo.Endereco;
import lombok.Data;

@Data
public class PedidoEventoDto {
    private Long pedidoId;
    private Endereco endereco;
}
