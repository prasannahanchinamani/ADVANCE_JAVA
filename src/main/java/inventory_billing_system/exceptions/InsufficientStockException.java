package inventory_billing_system.exceptions;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String msg) {
        super(msg);
    }
}
