package demo.RegistroPedidos;

import static org.mockito.Mockito.*;

import demo.Dtos.DtoPedido;
import demo.Dtos.DtoResponseApiViacep;
import demo.Service.RegarDeLocal.RegrasDeLocalidadeDePedido;
import demo.Service.RegarDeLocal.ViaCepCliente;
import infra.RegiaoInvalida;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestDaPrimeiraValidacao {

    @Mock
    private ViaCepCliente viacep;

    @InjectMocks
    private RegrasDeLocalidadeDePedido PrimeiraValidacao;


    @Test
    @DisplayName("deveria ser valido")
    public void Teste1PrimeiraValicaoDeLocal(){

        DtoResponseApiViacep.Request retorno = new DtoResponseApiViacep.Request();
        retorno.setRegiao("Nordeste");

        when(viacep.buscarPorCidade(anyString())).thenReturn(retorno);

        DtoPedido.Request dto = new DtoPedido.Request();
        dto.setCep("58046-527");

        Assertions.assertDoesNotThrow(() -> PrimeiraValidacao.NaoEntregaNoLocal(dto));
    }

    @Test
    @DisplayName("deveria ser invalido")
    public void Teste2doPrimeiraValicaoDeLocal(){

        DtoResponseApiViacep.Request retorno = new DtoResponseApiViacep.Request();
        retorno.setRegiao("Suldeste");

        when(viacep.buscarPorCidade(anyString())).thenReturn(retorno);

        DtoPedido.Request dto = new DtoPedido.Request();
        dto.setCep("20000-000");

        Assertions.assertThrows(RegiaoInvalida.class ,() -> PrimeiraValidacao.NaoEntregaNoLocal(dto));
    }
}



