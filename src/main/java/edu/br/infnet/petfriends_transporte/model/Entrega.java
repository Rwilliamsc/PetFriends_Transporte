package edu.br.infnet.petfriends_transporte.model;

import edu.br.infnet.petfriends_transporte.vo.Endereco;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEntrega;

    @Embedded
    private Endereco enderecoDestino;

    public Entrega() {}

    public Entrega(Long pedidoId, String status, LocalDateTime dataCriacao, Endereco enderecoDestino) {
        this.pedidoId = pedidoId;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.enderecoDestino = enderecoDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrega)) return false;
        Entrega entrega = (Entrega) o;
        return Objects.equals(id, entrega.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
