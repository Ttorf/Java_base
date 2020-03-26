package task1.exeptions;


public class ItemAlreadyPlacedException extends Exception {
    public ItemAlreadyPlacedException() {
    }

    public ItemAlreadyPlacedException(String message) {
        super(message);
    }

    public ItemAlreadyPlacedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemAlreadyPlacedException(Throwable cause) {
        super(cause);
    }

    public ItemAlreadyPlacedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
