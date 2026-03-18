package demo.controller;

import demo.Dtos.DtoPedido;
import demo.Service.RegistrarPedidos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class ControllerPedidos {

    @Autowired
    public RegistrarPedidos pedidosService;

    @PostMapping("/fazerPedido")
    public ResponseEntity<String> ResgistroPedido(@Valid @RequestBody DtoPedido.Request dto){
        String resposta = pedidosService.RegistarPedido(dto);
        return ResponseEntity.ok(resposta);
    }
}
