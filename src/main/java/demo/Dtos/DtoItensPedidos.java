package demo.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

public record DtoItensPedidos(
      @Id
      Long IdPedido,
      @NotNull
      String nomeProduto,
      @NotNull
      Integer quantidade,
      @NotNull
      @Positive
      Float PrecoUnitario
){}
