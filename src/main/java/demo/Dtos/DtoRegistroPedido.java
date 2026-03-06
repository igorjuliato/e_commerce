package demo.Dtos;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record DtoRegistroPedido(
    @NotNull
    List<DtoItensPedidos> itens,
    @NotNull
     String nomeCliente,
    @NotNull
     Date dataDoPedido,
    @NotNull
     String localPedido
) {}

