package demo.Repository;

import demo.domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pedidosRepository extends JpaRepository<Pedidos, Long > {

}
