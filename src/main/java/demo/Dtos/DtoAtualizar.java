package demo.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

public class DtoAtualizar {

     @NoArgsConstructor
     @Getter
     @AllArgsConstructor
     @Builder
     @Data
     public static class Request {
         @NotBlank
         Long id;

         String nomeProduto;

         BigDecimal preco;
     }
}
