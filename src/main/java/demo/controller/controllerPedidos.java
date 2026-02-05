package demo.controller;

import demo.RegistroPedido.Dtos.DtoItensPedidos;
import demo.RegistroPedido.Dtos.DtoResgistroPedido;
import demo.RegistroPedido.service.RegistrarPedidos;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bebeConforto")
public class controllerPedidos {

    public RegistrarPedidos pedidos;

    @PostMapping("/fazerPedido")
    public void ResgistroPedido(@Valid @RequestBody DtoResgistroPedido dados,@Valid @RequestBody DtoItensPedidos dados2){
        pedidos.RegistarPedido(dados, dados2);
    }

}
