package demo.service;

import demo.Dtos.DtoResgistroPedido;
import demo.repository.PedidosRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrarPedidos {

    private final PedidosRepository pedido;

    public void RegistarPedido(DtoResgistroPedido dto){
      PedidosRepository pedido = new PedidosRepository();

    }

}
