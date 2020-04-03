package task.laba1.exceptions;

public class ItemStoreException extends Exception {

    public ItemStoreException() {
    }

    public ItemStoreException(String message) {
        super(message);
    }

    public ItemStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemStoreException(Throwable cause) {
        super(cause);
    }

    public ItemStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
