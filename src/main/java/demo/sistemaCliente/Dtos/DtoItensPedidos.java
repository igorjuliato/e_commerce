package demo.sistemaCliente.Dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DtoItensPedidos(
        @NotNull
      long idProduto,
        @NotNull
      Integer quantidade

){}
