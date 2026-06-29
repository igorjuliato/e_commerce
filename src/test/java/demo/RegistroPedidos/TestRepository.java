package demo.RegistroPedidos;

import static org.mockito.Mockito.*;

import demo.DtoFactory.PedidoDtoFactory;
import demo.sistemaCliente.Dtos.DtoPedido;
import demo.sistemaCliente.Repository.PedidosRepository;
import demo.sistemaCliente.Service.RegarDeLocal.RegrasDeLocalidadeDePedido;
import demo.sistemaCliente.Service.RegistrarPedidos;
import demo.sistemaCliente.domain.Pedidos;
import demo.sistemaCliente.mapper.ItensMapper;
import demo.sistemaCliente.mapper.PedidosMapper;
import infra.PedidoInvalido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class TestRepository {

    @InjectMocks
    private RegistrarPedidos service;

    @Mock
    private RegrasDeLocalidadeDePedido validacao1;

    @Spy
    private PedidosMapper mapper1;

    private ItensMapper mapper2 = Mappers.getMapper(ItensMapper.class);

    @Mock
    private PedidosRepository repository;

    @Captor
    private ArgumentCaptor<Pedidos> captor;

    public static Stream<Arguments> todosOsCenarios() {
       return Stream.of(
               Arguments.of(PedidoDtoFactory.valido(), null),
               Arguments.of(PedidoDtoFactory.invalidoPorQuantidade(), PedidoInvalido.class)
        );
    }


    @DisplayName("deve ser valido")
    @ParameterizedTest
    @MethodSource("todosOsCenarios")
    public void testeDeRegistro(DtoPedido.Request dto, Class<?> excecaoEsperada){

        doNothing().when(validacao1).NaoEntregaNoLocal(dto);

        service.RegistarPedido(dto);
        verify(repository).save(captor.capture());

        Pedidos pedidosSalvos = captor.getValue();
        Assertions.assertNotNull(pedidosSalvos);
        Assertions.assertEquals(3, pedidosSalvos.getListPedido().size());

        pedidosSalvos.getListPedido().forEach(itensPedidos ->
                Assertions.assertNotNull(itensPedidos.getPedidos()));
    }
}
