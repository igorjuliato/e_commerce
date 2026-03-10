package demo.AssertionsTest;
import demo.Dtos.DtoItensPedidos;
import demo.domain.Pedidos;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.List;


public class PedidoAssertions {

    private Pedidos dados;

    private final Pedidos atual;

    public PedidoAssertions(Pedidos atual) {
        this.atual = atual;
    }

    public static PedidoAssertions afrimaQue_Pedido (Pedidos atual){
        return new PedidoAssertions(atual);
    }
     public void FoiConvertido_DtoPedido (){
         Assertions.assertEquals("igor", dados.getCliente());
         List<DtoItensPedidos> esperado = List.of(
                 new DtoItensPedidos(1,3, null),
                 new DtoItensPedidos(2, 10, null),
                 new DtoItensPedidos(3, 6, null)
         );
         Assertions.assertEquals(esperado, dados.getListPedido());
         Assertions.assertEquals(LocalDate.of(2026, 02, 20) ,dados.getDataPedido());
         Assertions.assertEquals("bougainville",dados.getLocalPedido());
     }



}
