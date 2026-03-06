package demo.mapper;

import demo.Dtos.DtoRegistroPedido;
import demo.domain.Pedidos;

public class PedidosMapper {

    public static Pedidos toEntity(DtoRegistroPedido dto){
        Pedidos pedidos = new Pedidos();
        pedidos.setCliente(dto.nomeCliente());
        pedidos.setDataPedido(dto.dataDoPedido());
        pedidos.setLocalPedido(dto.localPedido());
        return pedidos;
    }
}
