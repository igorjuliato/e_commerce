package demo.sistemaOwner.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

@Entity
public class OwnerUsuario {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String Senha;
}
