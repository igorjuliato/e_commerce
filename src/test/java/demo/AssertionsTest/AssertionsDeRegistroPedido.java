package demo.AssertionsTest;
import demo.Dtos.DtoPedido;
import demo.Service.RegistrarPedidos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class AssertionsDeRegistroPedido {

    RegistrarPedidos service;

    AssertionsDeRegistroPedido(RegistrarPedidos service){
        this.service = service;
    }

    @ParameterizedTest
    @MethodSource("demo.DtoFactory.PedidoDtoFactory#TodosOsCenarios")
    public void TestarDtosDeRegistro(DtoPedido.Request dto, Boolean esperado){
       if(esperado == null){
           Assertions.assertDoesNotThrow(() -> service.RegistarPedido(dto));
       } else {
           Assertions.assertThrows(Exception.class,() -> service.RegistarPedido(dto));
       }
    }
}
