package demo.Service;

import demo.Dtos.DtoBuscarPedido;
import demo.Repository.pedidosRepository;
import demo.controller.ControllerAreaFabricante;
import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import infra.execepitionsPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class calcularPedido {

    @Autowired
    private final pedidosRepository repository;

    public calcularPedido(pedidosRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private ControllerAreaFabricante controller;

    @Transactional
    public void calcularprecoDeCompra(DtoBuscarPedido dto) {
        Optional<Pedidos> BuscaPedido = repository.findById(dto.id());

        if(BuscaPedido.isPresent()){
           Pedidos pedido = BuscaPedido.get();
           List<ItensPedidos> ItensDoCliente = pedido.getListPedido();
           var Iten = ItensDoCliente.stream().map(
                   i -> {

                   })

    } else {
           infra.execepitionsPedidos execepitionsPedidos = new execepitionsPedidos("pedido não encontrado");
            controller.handleResourceNotFound(execepitionsPedidos);
        }
        }

}
