package demo.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import org.springframework.data.annotation.Id;

import java.util.List;

@Builder
public record DtoItensPedidos(
        @NotNull
      long idProduto,
        @NotNull
      Integer quantidade,
        @NotNull
        List<DtoItensPedidos> itens
){}
