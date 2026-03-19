package demo.controller;

import infra.execepitionsPedidoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvence {

 @ExceptionHandler(execepitionsPedidoNaoEncontrado.class)
 public ResponseEntity<String> execepitionPedidoNaoEncontrado (execepitionsPedidoNaoEncontrado ex){
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pedido não achado");
 }

}
