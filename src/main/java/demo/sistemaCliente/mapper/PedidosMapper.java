package demo.sistemaCliente.mapper;

import demo.sistemaCliente.Dtos.DtoPedido;
import demo.sistemaCliente.domain.Pedidos;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface PedidosMapper {

    Pedidos converter(DtoPedido.Request dto);
}
