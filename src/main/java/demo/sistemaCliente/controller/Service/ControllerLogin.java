package demo.sistemaCliente.controller.Service;

import demo.sistemaCliente.Dtos.DtoConta;
import demo.sistemaCliente.Service.ValidaçãoDeUsuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ControllerLogin {

    private ValidaçãoDeUsuario validação;

    public ResponseEntity<DtoConta.Response> UsuarioCliente(@Valid @RequestBody DtoConta.Request dto){
        return ResponseEntity.ok(validação.ValidarUsuario(dto));
    }

}
