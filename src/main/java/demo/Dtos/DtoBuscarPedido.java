package demo.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoBuscarPedido(
        @NotBlank
        long id
) {
}
