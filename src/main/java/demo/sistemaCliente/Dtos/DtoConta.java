package demo.sistemaCliente.Dtos;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DtoConta {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Valid
    public final class Request{
        private String email;
        private String senha;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Valid
    public final class Response{
    }
}
