package demo.sistemaCliente.Service;

import demo.sistemaCliente.Dtos.DtoDeletarPedido;
import demo.sistemaCliente.Repository.PedidosRepository;
import demo.sistemaCliente.domain.Pedidos;
import infra.ExecepitionsPedidoNaoEncontrado;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletarPedido {

    @Autowired
    private PedidosRepository repository;

    public void deletar(@Valid DtoDeletarPedido.Request dto) {
       Optional<Pedidos> id = Optional.of(repository.findById(dto.getId())
               .orElseThrow(() -> new ExecepitionsPedidoNaoEncontrado("seu pedido não existe")));

       repository.delete(id.get());
    }
}
