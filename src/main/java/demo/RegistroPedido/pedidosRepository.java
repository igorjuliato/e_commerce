package demo.RegistroPedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface pedidosRepository extends JpaRepository<Pedidos, Long > {
}
