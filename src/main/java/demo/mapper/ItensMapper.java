package demo.mapper;

import demo.Dtos.DtoItensPedidos;
import demo.domain.ItensPedidos;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(nullValuePropertyMappingStrategy = IGNORE)
public interface ItensMapper {
    ItensPedidos converter(DtoItensPedidos dto);
}
