package demo.RegistroPedido;

import demo.RegistroPedido.Dtos.DtoResgistroPedido;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Pedidos {

    @Id
    private Long IdPedido;

    private String Cliente;
    private Date dataPedido;
    private String localPedido;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    private List<ItensPedidos> pedidos;

    public void PedidosRepository(){}

     public Pedidos(){}

    public Pedidos(DtoResgistroPedido dto){
         this.IdPedido = dto.idPedido();
         this.Cliente = dto.nomeCliente();
         this.dataPedido = dto.dataDoPedido();
         this.localPedido = dto.localPedido();
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

    public String getLocalPedido() {
        return localPedido;
    }

    public void setLocalPedido(String localPedido) {
        this.localPedido = localPedido;
    }
}
