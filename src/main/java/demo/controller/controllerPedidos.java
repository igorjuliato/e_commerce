package demo.controller;

import demo.Dtos.DtoResgistroPedido;
import demo.service.RegistrarPedidos;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bebeConforto")
public class controllerPedidos {

    public RegistrarPedidos pedidos;

    @PostMapping("/fazerPedido")
    public void ResgistroPedido( @Valid DtoResgistroPedido dados){
        pedidos.RegistarPedido(dados);
    }

}
