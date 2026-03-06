package demo.mapper;

import demo.Dtos.DtoItensPedidos;
import demo.domain.ItensPedidos;

public class ItensPedidosMapper {

    public static ItensPedidos toEntidy(DtoItensPedidos dto){
        ItensPedidos itens = new ItensPedidos();
        itens.setId(dto.idProduto());
        itens.setQuantidade(dto.quantidade());
        return itens;
    }
}
