package demo.RegistroPedido.service;

import demo.RegistroPedido.Dtos.DtoItensPedidos;
import demo.RegistroPedido.Dtos.DtoResgistroPedido;
import demo.RegistroPedido.ItensPedidos;
import demo.RegistroPedido.Pedidos;
import demo.RegistroPedido.pedidosRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RegistrarPedidos {
    private final pedidosRepository repository;

    private Pedidos pedido;

    public RegistrarPedidos(pedidosRepository repository) {
        this.repository = repository;
    }

    List<ItensPedidos> itensPedidos = new ArrayList<>();

    public void RegistarPedido(DtoResgistroPedido dto, DtoItensPedidos dtoItens){
        Pedidos pedido = new Pedidos(dto);

        for (DtoItensPedidos i : dto.itens()){
            ItensPedidos itens = new ItensPedidos();
            itens.setNome(i.nomeProduto());
            itens.setQuantidade(i.quantidade());
            itens.setPreçoUnitario(i.PrecoUnitario());
            itens.getId()""

        }
    }
}
