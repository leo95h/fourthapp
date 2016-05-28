package br.com.fourthapp.util;

/**
 *
 * @author fernando
 */
public class FourthAppException extends RuntimeException {

    public FourthAppException(String message) {
        super(message);
    }

    public FourthAppException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
