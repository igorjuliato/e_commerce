package demo.Dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


public class DtoPedido{


    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
    @NotNull
    List<DtoItensPedidos> itens;
    @NotNull
    String nomeCliente;
    @NotNull
    LocalDate dataDoPedido;
    @NotNull
    String localPedido;
}}

