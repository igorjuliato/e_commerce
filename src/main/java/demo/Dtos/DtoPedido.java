import demo.Dtos.DtoItensPedidos;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class DtoPedido {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {

        @NotNull
        private List<DtoItensPedidos> itens;

        @NotNull
        private String nomeCliente;

        @NotNull
        private LocalDate dataDoPedido;

        @NotNull
        private String localPedido;
    }
}