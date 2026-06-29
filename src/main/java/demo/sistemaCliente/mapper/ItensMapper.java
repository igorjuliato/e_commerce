package demo.sistemaCliente.mapper;

import demo.sistemaCliente.Dtos.DtoItensPedidos;
import demo.sistemaCliente.domain.ItensPedidos;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface ItensMapper {
    ItensPedidos converter(DtoItensPedidos dto);
}
