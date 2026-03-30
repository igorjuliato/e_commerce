package demo.DtoFactory;

import demo.Dtos.DtoItensPedidos;
import demo.Dtos.DtoPedido;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PedidoDtoFactory {

    public static Request criarProdutoDtoRequest() {
        return new Request(DtoPedido.Request.builder());
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Request {

       private final DtoPedido.Request.RequestBuilder builder;

           public DtoPedido.Request valido() {
               var iten1 = DtoItensPedidos.builder()
                       .idProduto(1)
                       .quantidade(3)
                       .build();
               var iten2 = DtoItensPedidos.builder()
                       .idProduto(2)
                       .quantidade(10)
                       .build();
               var iten3 = DtoItensPedidos.builder()
                       .idProduto(3)
                       .quantidade(6)
                       .build();
               var dto = DtoPedido.Request.builder()
                       .itens(List.of(iten1, iten2, iten3))
                       .nomeCliente("igor")
                       .dataDoPedido(LocalDate.of(2026, 02, 20))
                       .cep(" 58010-000")
                       .build();
               return dto;
           }
        public DtoPedido.Request InvalidoPorLocal() {
            var iten1 = DtoItensPedidos.builder()
                    .idProduto(1)
                    .quantidade(3)
                    .build();
            var iten2 = DtoItensPedidos.builder()
                    .idProduto(2)
                    .quantidade(10)
                    .build();
            var iten3 = DtoItensPedidos.builder()
                    .idProduto(3)
                    .quantidade(6)
                    .build();
            var dto = DtoPedido.Request.builder()
                    .itens(List.of(iten1, iten2, iten3))
                    .nomeCliente("igor")
                    .dataDoPedido(LocalDate.of(2026, 02, 20))
                    .cep("05600-000")
                    .build();
            return dto;
        }

        public DtoPedido.Request invalidoPorQuantidade() {
            var iten1 = DtoItensPedidos.builder()
                    .idProduto(1)
                    .quantidade(0)
                    .build();
            var iten2 = DtoItensPedidos.builder()
                    .idProduto(2)
                    .quantidade(0)
                    .build();
            var iten3 = DtoItensPedidos.builder()
                    .idProduto(3)
                    .quantidade(6)
                    .build();
            var dto = DtoPedido.Request.builder()
                    .itens(List.of(iten1, iten2, iten3))
                    .nomeCliente("igor")
                    .dataDoPedido(LocalDate.of(2026, 02, 20))
                    .cep("05600-000")
                    .build();
            return dto;
        }
       }

    static Stream<DtoPedido.Request> TodosOsCenarios( ){
        return Stream.of(
                PedidoDtoFactory.criarProdutoDtoRequest().valido(),
                PedidoDtoFactory.criarProdutoDtoRequest().InvalidoPorLocal(),
                PedidoDtoFactory.criarProdutoDtoRequest().invalidoPorQuantidade()
        );}
    }

