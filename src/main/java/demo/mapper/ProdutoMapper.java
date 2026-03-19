package demo.mapper;

import demo.Dtos.DtoAtualizar;
import demo.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface ProdutoMapper {
    Produto converter(DtoAtualizar.Request dto);

    void atualizar(DtoAtualizar.Request dto , @MappingTarget Produto produto);
}
