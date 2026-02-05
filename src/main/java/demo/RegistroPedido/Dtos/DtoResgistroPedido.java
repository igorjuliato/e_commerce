package demo.RegistroPedido.Dtos;

import demo.RegistroPedido.ItensPedidos;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public record DtoResgistroPedido<pedidos>(
      Long idPedido,
    @NotNull
      List<DtoItensPedidos> itens,
    @NotNull
     String nomeCliente,
    @NotNull
     Date dataDoPedido,
    @NotNull
     String localPedido
) {}

