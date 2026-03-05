package demo.Service;

import demo.Dtos.DtoResgistroPedido;
import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import demo.Repository.pedidosRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistrarPedidos {
    private final pedidosRepository repository;

    private Pedidos pedido;

    public RegistrarPedidos(pedidosRepository repository) {
        this.repository = repository;
    }

    public void RegistarPedido(DtoResgistroPedido dto){

        Pedidos pedidos = new Pedidos(dto);

           List<ItensPedidos> listaDePedidos = dto.itens().stream().
                   map(i -> {
                       ItensPedidos iten = new ItensPedidos();
                       iten.setNome(i.nomeProduto());
                       iten.setQuantidade(i.quantidade());
                       iten.setPreçoUnitario(i.PrecoUnitario());

                       iten.setPedidos(pedidos);

                       return iten;
                   }).toList();

                   pedidos.setListPedido(listaDePedidos);

                   repository.save(pedidos);
        }
    }

