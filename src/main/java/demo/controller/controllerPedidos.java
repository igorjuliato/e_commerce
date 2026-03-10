package demo.controller;

import demo.Dtos.DtoPedido;
import demo.Service.RegistrarPedidos;
import demo.mapper.PedidosMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compras")
public class controllerPedidos {

    public RegistrarPedidos pedidosService;

    private PedidosMapper mapperPedido;



    @PostMapping("/fazerPedido")
    public void ResgistroPedido(@Valid @RequestBody DtoPedido.Request dto){
        pedidosService.RegistarPedido(dto);
    }


}
