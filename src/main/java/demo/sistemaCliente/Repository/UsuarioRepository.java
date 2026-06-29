package demo.sistemaCliente.Repository;

import demo.sistemaCliente.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query""
    String FindByEmail(@Param("email") String email);
}
