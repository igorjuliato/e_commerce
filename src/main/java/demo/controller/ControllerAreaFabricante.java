package demo.controller;

import demo.Dtos.DtoBuscarCliente;
import demo.Dtos.DtoBuscarPedido;
import demo.Service.areaFabricanteService;
import infra.execepitionsPedidos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paraFabricante")
public class ControllerAreaFabricante {

    private areaFabricanteService fabricante;

    @GetMapping
    public void calcularValorDeCompra(DtoBuscarPedido dto){
        fabricante.calcularprecoDeCompra(dto);
    }

    @ExceptionHandler(execepitionsPedidos.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFound(execepitionsPedidos ex) {
        return ex.getMessage();
    }
}
