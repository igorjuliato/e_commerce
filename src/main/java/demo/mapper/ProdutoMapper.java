package demo.mapper;

import demo.Dtos.DtoAtualizarECriarProduto;
import demo.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface ProdutoMapper {
    Produto converter(DtoAtualizarECriarProduto.Request dto);

    void atualizar(DtoAtualizarECriarProduto.Request dto , @MappingTarget Produto produto);
}
