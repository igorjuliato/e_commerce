package demo.Repository;

import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedidos, Long > {

    @Query("""
  SELECT i.produto.preco FROM ItensPedidos i WHERE i.id = :itemPedidoId
""")
    int buscarPrecoUnitario(@Param("itemPedidoId") Long itemPedidoId);
}
