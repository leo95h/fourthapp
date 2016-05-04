package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.PessoaDAO;
import br.com.fourthapp.dao.impl.PessoaDAOImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author fernando
 * @see Celia
 */
public class PessoaTest {

    private PessoaDAO dao;
    
    public PessoaTest() {
        dao = new PessoaDAOImpl();
    }

    @BeforeClass
    public static void setUpClass() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
