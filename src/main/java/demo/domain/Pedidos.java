package demo.domain;

import demo.Dtos.DtoResgistroPedido;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPedido;

    private String Cliente;

    private Date dataPedido;

    private String localPedido;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    private List<ItensPedidos> listPedido;

    public Pedidos(DtoResgistroPedido dto){
      this.Cliente = dto.nomeCliente();
      this. dataPedido = dto.dataDoPedido();
      this.localPedido = dto.localPedido();
    }

    public Pedidos(){}

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

    public String getLocalPedido() {
        return localPedido;
    }

    public void setLocalPedido(String localPedido) {
        this.localPedido = localPedido;
    }

    public List<ItensPedidos> getListPedido() {
        return listPedido;
    }

    public void setListPedido(List<ItensPedidos> listPedido) {
        this.listPedido = listPedido;
    }
}
