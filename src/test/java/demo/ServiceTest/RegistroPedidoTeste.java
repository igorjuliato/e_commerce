package demo.ServiceTest;

import static org.mockito.Mockito.*;
import demo.DtoFactory.PedidoDtoFactory;
import demo.Dtos.DtoItensPedidos;
import demo.Dtos.DtoPedido;
import demo.Repository.PedidosRepository;
import demo.Service.RegarDeLocal.RegrasDeLocalidadeDePedido;
import demo.Service.RegistrarPedidos;
import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import demo.mapper.ItensMapper;
import demo.mapper.PedidosMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class RegistroPedidoTeste {

    @Mock
    private RegrasDeLocalidadeDePedido regra;

    @Mock
    private PedidosMapper mapper1;

    @Mock
    private PedidosRepository repository;

    @Mock
    private ItensMapper mapper2;

    @InjectMocks
    private RegistrarPedidos service;

    public static Stream<Arguments> TodosOsCenarios() {
        return Stream.of(
                Arguments.of(PedidoDtoFactory.criarProdutoDtoRequest().valido(), null),
                Arguments.of(PedidoDtoFactory.criarProdutoDtoRequest().InvalidoPorLocal(), RuntimeException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("TodosOsCenarios")
    public void TestarDtosDeRegistro(DtoPedido.Request dto, Class<? extends Exception> esperado){

        when(mapper1.converter(dto)).thenReturn(new Pedidos());

        when(mapper2.converter(any())).thenReturn(new ItensPedidos());

        when(repository.save(any())).thenReturn(new Pedidos());

        if(esperado != null){
           doThrow(new RuntimeException())
                   .when(regra)
                   .NaoEntregaNoLocal(dto);
        } else {
            doNothing()
                    .when(regra)
                    .NaoEntregaNoLocal(dto);
        }


        if (esperado != null) {
            Assertions.assertThrows(esperado ,()-> service.RegistarPedido(dto));
        } else {
            Assertions.assertDoesNotThrow(() -> service.RegistarPedido(dto));
        }
    }

}



