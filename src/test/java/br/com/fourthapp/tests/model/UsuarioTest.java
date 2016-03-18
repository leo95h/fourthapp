package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class UsuarioTest {

    private final UsuarioDAOImpl dao;
    private final Usuario usuario;

    public UsuarioTest() {
        dao = new UsuarioDAOImpl();
        usuario = new Usuario("paschualetto", "senha10");
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

    @Test
    public void persistIfNotExists() {
        Usuario u = dao.buscarUsuarioPorLogin(usuario.getLogin());
        if(u == null) {
            dao.save(usuario);
        } else {
            System.out.println("Usuário já existe!");
        }
    }
}
