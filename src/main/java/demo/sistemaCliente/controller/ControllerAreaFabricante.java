package demo.sistemaCliente.controller;

import demo.sistemaCliente.Dtos.DtoAtualizarECriarProduto;
import demo.sistemaCliente.Dtos.DtoBuscarPedido;
import demo.sistemaCliente.Service.CalcularPedido;
import demo.sistemaCliente.Service.DecisaoDeAtualizarOuCriar;
import jakarta.validation.Valid;
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
    private DecisaoDeAtualizarOuCriar CriarOuAtualizar;

    @GetMapping("/{id}/calcularPedido")
    public ResponseEntity<BigDecimal> calcularValorDeCompra(@Valid DtoBuscarPedido.Request dto){
        BigDecimal valorTotal = calcular.calcularPrecoDeCompra(dto);
        return ResponseEntity.ok(valorTotal);
    }

    @PostMapping("/Atualizar/Criar")
    public ResponseEntity<DtoAtualizarECriarProduto.Response> AtualizarOuCriarProduto (@RequestBody @Valid DtoAtualizarECriarProduto.Request dto){
        DtoAtualizarECriarProduto.Response resposta = CriarOuAtualizar.VerificarNoDB(dto);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/confirmar")
    public ResponseEntity<String> Confirmar (@Valid DtoAtualizarECriarProduto.RequestResposta dto){
       String mensagem = CriarOuAtualizar.CriarProduto(dto);
       return ResponseEntity.ok(mensagem);
    }
}
