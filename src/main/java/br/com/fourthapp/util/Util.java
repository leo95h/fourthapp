package br.com.fourthapp.util;

/**
 *
 * @author fernando
 */
public class Util {

    public static boolean hasText(String text) {
        if(text == null) {
            return false;
        }
        return !"".equals(text);
    }
}
