package inventory_billing_system.exceptions;

public class InvalidDiscountException extends RuntimeException {
    public InvalidDiscountException(String msg) {
        super(msg);
    }
}
