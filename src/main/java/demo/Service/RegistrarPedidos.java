package demo.Service;

import demo.Dtos.DtoRegistroPedido;
import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import demo.Repository.pedidosRepository;
import demo.mapper.ItensPedidosMapper;
import demo.mapper.PedidosMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistrarPedidos {
    private final pedidosRepository repository;

    private Pedidos pedido;

    public RegistrarPedidos(pedidosRepository repository) {
        this.repository = repository;
    }

    public void RegistarPedido(DtoRegistroPedido dto){

        Pedidos pedidos = PedidosMapper.toEntity(dto);

           List<ItensPedidos> listaDePedidos = dto.itens().stream().
                   map(i -> {
                       ItensPedidos iten = ItensPedidosMapper.toEntidy(i);
                       iten.setPedidos(pedidos);

                       return iten;
                   }).toList();

                   pedidos.setListPedido(listaDePedidos);

                   repository.save(pedidos);
        }
    }

