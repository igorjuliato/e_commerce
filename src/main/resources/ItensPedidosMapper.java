package demo.mapperTest;

import demo.Dtos.DtoItensPedidos;
import demo.domain.ItensPedidos;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(nullValuePropertyMappingStrategy = IGNORE)
public interface ItensPedidosMapper {
    ItensPedidos converter(DtoItensPedidos dto);
}
