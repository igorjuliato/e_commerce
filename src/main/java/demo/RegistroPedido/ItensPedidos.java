package demo.RegistroPedido;

import demo.RegistroPedido.Dtos.DtoItensPedidos;
import demo.RegistroPedido.Dtos.DtoResgistroPedido;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "itens_pedidos")
public class ItensPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    private float PrecoUnitario;

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedidos pedidos;

    public ItensPedidos(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreçoUnitario() {
        return PrecoUnitario;
    }

    public void setPreçoUnitario(float preçoUnitario) {
        PrecoUnitario = preçoUnitario;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    @ManyToOne(optional = false)
    private Pedidos pedidos2;

}
