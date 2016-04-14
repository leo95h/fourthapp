package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Usuario;
import br.com.fourthapp.entity.fixture.UsuarioFixture;
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
    private static List<Usuario> usuarios;

    public UsuarioTest() {
        System.out.println("Construtor!");
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("@BeforeClass!");
        dao = new UsuarioDAOImpl();
        usuario = UsuarioFixture.usuarioPadrao();
        usuarios = UsuarioFixture.usuarios(10);
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass!");
    }

    @Before
    public void setUp() {
        System.out.println("@Before!");
    }

    @After
    public void tearDown() {
        System.out.println("@After!");
    }

    @Test
    public void persistIfNotExists() {
        System.out.println("PersistIfNotExists!");
        if (!existsUsuario(usuario.getLogin())) {
            dao.save(usuario);
        }
    }

    @Test
    public void findAllUsuarios() {
        System.out.println("FindAllUsuarios!");
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = dao.listAll();
        Assert.assertFalse(usuarios.isEmpty());
    }

    @Test
    public void countUsuarios() {
        System.out.println("CountUsuarios!");
        int value = dao.count();
        Assert.assertFalse(value == 0);
    }

    @Test
    public void persistLotUsuarios() {
        for(Usuario u : usuarios) {
            if(!existsUsuario(u.getLogin())) {
                dao.save(u);
            }
        }
    }
    
    private boolean existsUsuario(String login) {
        return dao.buscarUsuarioPorLogin(login) != null;
    }
}
