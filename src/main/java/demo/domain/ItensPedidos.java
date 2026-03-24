package demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "itens_pedidos")
public class ItensPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItensPedido;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "Pedidos_Cliente")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedidos_id", nullable = false)
    private Pedidos pedidos;

    public ItensPedidos(){}
}
