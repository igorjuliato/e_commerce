package demo.controller;

import demo.Dtos.DtoBuscarPedido;
import demo.Dtos.DtoAtualizar;
import demo.Service.CalcularPedido;
import demo.Service.AtualizarProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("paraFabricante")
public class ControllerAreaFabricante {

    @Autowired
    private CalcularPedido calcular;

    @Autowired
    private AtualizarProduto Modificar;

    @GetMapping("/{id}/calcularPedido")
    public ResponseEntity<BigDecimal> calcularValorDeCompra(DtoBuscarPedido.Request dto){
        BigDecimal valorTotal = calcular.calcularPrecoDeCompra(dto);
        return ResponseEntity.ok(valorTotal);
    }

    @PatchMapping("{id}/ModificarPedido")
    public ResponseEntity<String> ModificaçãoDeProduto(DtoAtualizar.Request dto) {
         Modificar.ModificarProduto(dto);
         return ResponseEntity.ok();
    }
}
