package demo.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

public record DtoItensPedidos(
      @NotNull
      long idProduto,
      @NotNull
      Integer quantidade
){}
