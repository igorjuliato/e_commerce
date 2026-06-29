package demo.sistemaCliente.Service;

import demo.sistemaCliente.Dtos.DtoConta;
import demo.sistemaCliente.Repository.UsuarioRepository;
import demo.sistemaCliente.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidaçãoDeUsuario {

    @Autowired
    private UsuarioRepository repository;

    public DtoConta.Response ValidarUsuario(DtoConta.Request dto) {

        Usuario usuario = repository.findBy

    }
}
