package infra;

public class PedidoInvalido extends RuntimeException {
    public PedidoInvalido(String message) {
        super(message);
    }
}
