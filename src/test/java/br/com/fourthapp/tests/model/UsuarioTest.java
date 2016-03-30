package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
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
public class UsuarioTest {

    private static UsuarioDAOImpl dao;
    private static Usuario usuario;

    public UsuarioTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        dao = new UsuarioDAOImpl();
        usuario = new Usuario("paschualetto", "senha10");
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
        if (u == null) {
            u = dao.merge(usuario);
        }
        Assert.assertNotNull(u);
    }

    @Test
    public void findAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = dao.listAll();
        Assert.assertFalse(usuarios.isEmpty());
    }

    @Test
    public void countUsuarios() {
        int value = dao.count();
        Assert.assertFalse(value == 0);
    }
}
