package demo.controller;

import demo.Dtos.DtoRegistroPedido;
import demo.Service.RegistrarPedidos;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compras")
public class controllerPedidos {

    public RegistrarPedidos pedidosService;

    @PostMapping("/fazerPedido")
    public void ResgistroPedido(@Valid @RequestBody DtoRegistroPedido dto){
        pedidosService.RegistarPedido(dto);
    }


}
