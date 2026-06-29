package demo.sistemaCliente.controller;

import demo.sistemaCliente.Dtos.DtoDeletarPedido;
import demo.sistemaCliente.Dtos.DtoPedido;
import demo.sistemaCliente.Service.DeletarPedido;
import demo.sistemaCliente.Service.RegistrarPedidos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class ControllerPedidos {

    @Autowired
    public RegistrarPedidos pedidosService;

    @Autowired
    public DeletarPedido deletarPedido;

    @PostMapping("/fazerPedido")
    public ResponseEntity<String> ResgistroPedido(@Valid @RequestBody DtoPedido.Request dto){
        String reposta = pedidosService.RegistarPedido(dto);
        return ResponseEntity.ok(reposta);
    }

    @DeleteMapping("/{id}/deletarPedido")
    public ResponseEntity<String> DeletarPedido(@RequestBody @Valid DtoDeletarPedido.Request dto){
        deletarPedido.deletar(dto);
        return ResponseEntity.ok("seu pedido foi deletado com sucesso");
    }
}
