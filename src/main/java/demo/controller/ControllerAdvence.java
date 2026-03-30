package demo.controller;

import infra.ExecepitionsPedidoNaoEncontrado;
import infra.PedidoInvalido;
import infra.ProdutoExistente;
import infra.RegiaoInvalida;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvence {

 @ExceptionHandler(ExecepitionsPedidoNaoEncontrado.class)
 public ResponseEntity<String> execepitionPedidoNaoEncontrado (ExecepitionsPedidoNaoEncontrado ex){
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido não achado");
 }

 @ExceptionHandler(ProdutoExistente.class)
 public ResponseEntity<String> pedidoJaExistente (ProdutoExistente ex){
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido ja existe");
 }

    @ExceptionHandler(RegiaoInvalida.class)
    public ResponseEntity<String> RegiaoInvalida (ProdutoExistente ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido ja existe");
    }

    @ExceptionHandler(PedidoInvalido.class)
    public ResponseEntity<String> PedidoInvalido (ProdutoExistente ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido ja existe");
    }
}
