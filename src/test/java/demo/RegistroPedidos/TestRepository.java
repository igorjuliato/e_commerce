package demo.RegistroPedidos;

import static org.mockito.Mockito.*;

import demo.DtoFactory.PedidoDtoFactory;
import demo.Dtos.DtoPedido;
import demo.Repository.PedidosRepository;
import demo.Service.RegarDeLocal.RegrasDeLocalidadeDePedido;
import demo.Service.RegistrarPedidos;
import demo.domain.Pedidos;
import demo.mapper.ItensMapper;
import infra.RegiaoInvalida;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class TestRepository {

    @InjectMocks
    private RegistrarPedidos service;

    @Mock
    private RegrasDeLocalidadeDePedido validacao1;

    @Spy
    private ItensMapper mapper;

    @Mock
    private PedidosRepository repository;

    public static Stream<Arguments> todosOsCenarios() {
       return Stream.of(
               Arguments.of(PedidoDtoFactory.criarProdutoDtoRequest().invalidoPorQuantidade(),
                        RegiaoInvalida.class),
                Arguments.of(PedidoDtoFactory.criarProdutoDtoRequest().valido(), null)
        );
    }


    @DisplayName("deve ser valido")
    @ParameterizedTest
    @MethodSource("todosOsCenarios")
    public void testeDeRegistro(DtoPedido.Request dto, Class<?> excecaoEsperada){

        doNothing().when(validacao1).NaoEntregaNoLocal(dto);

        Pedidos resultado = mapper.converter(dto);

    }
}
