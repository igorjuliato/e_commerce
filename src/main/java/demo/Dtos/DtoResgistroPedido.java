package demo.Dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public class DtoResgistroPedido {
    @NotNull
    private long IdPedido;
    @NotNull
     private List<ItensPedidos> pedidos;
    @NotNull
     private String nomeCliente;
    @NotNull
     private Date dataDoPedido;
    @NotNull
    private String localPedido;

}
