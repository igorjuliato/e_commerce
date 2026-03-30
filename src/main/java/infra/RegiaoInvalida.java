package infra;

public class RegiaoInvalida extends RuntimeException {
    public RegiaoInvalida(String message) {
        super(message);
    }
}
