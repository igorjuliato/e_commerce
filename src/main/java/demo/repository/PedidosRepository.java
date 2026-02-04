package demo.repository;

import demo.Dtos.DtoResgistroPedido;
import demo.Dtos.ItensPedidos;
import demo.service.RegistrarPedidos;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table
public class PedidosRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPedido;

    private String Cliente;

    private Date dataPedido;

    @OneToMany
    private List<ItensPedidos> pedidos;

    private String EntregaPedido;



    public void PedidosRepository(){}

    public PedidosRepository(DtoResgistroPedido dto){

    }

    public Long getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(Long idPedido) {
        IdPedido = idPedido;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<ItensPedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItensPedidos> pedidos) {
        this.pedidos = pedidos;
    }

    public String getEntregaPedido() {
        return EntregaPedido;
    }

    public void setEntregaPedido(String entregaPedido) {
        EntregaPedido = entregaPedido;
    }
}
