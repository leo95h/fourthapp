package br.com.fourthapp.tests.connection;

import br.com.fourthapp.connection.DatabaseConnection;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class ConnectionTest {

    private static EntityManager entityManager;

    public ConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        entityManager = DatabaseConnection.createInstance().getEntityManager();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getEntityManagerInstance() {
        Assert.assertTrue("Conexão ativa!", entityManager.isOpen());
    }

}
