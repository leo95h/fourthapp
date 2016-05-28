package br.com.fourthapp.tests.model;

import br.com.fourthapp.util.Criptografia;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class CriptografiaTest {
    
    private static final String PASSWORD = "senha10abacaxi123";
    
    public CriptografiaTest() {
    }
    
    @Test
    public void testCriptografia() {
        String password = Criptografia.encriptar(PASSWORD);
        Assert.assertNotEquals(password, PASSWORD);
        Assert.assertEquals(password, Criptografia.encriptar("senha10abacaxi123"));
    }
}
