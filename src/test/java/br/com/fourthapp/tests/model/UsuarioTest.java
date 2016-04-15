package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Usuario;
import br.com.fourthapp.entity.fixture.UsuarioFixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class UsuarioTest {

    private static UsuarioDAOImpl dao;
    private static Usuario usuarioPadrao;
    private static Usuario usuarioTester;
    private static List<Usuario> usuarios;
    private static final int BUCKET_USUARIOS = 10;

    public UsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dao = new UsuarioDAOImpl();
        usuarioPadrao = UsuarioFixture.usuarioPadrao();
        usuarioTester = new Usuario("tester", "tester");
        usuarios = UsuarioFixture.usuarios(BUCKET_USUARIOS);
        populateDatabase();
    }

    /*
     * Descomentar o cleanDatabase() caso queira que todos os registros gerados
     * sejam descartados
     */
    @AfterClass
    public static void tearDownClass() {
        //cleanDatabase();
    }

    private static void populateDatabase() {
        cleanDatabase();
        for (Usuario u : usuarios) {
            if (dao.buscarUsuarioPorLogin(u.getLogin()) == null) {
                dao.save(u);
            }
        }
    }

    private static void cleanDatabase() {
        dao.deleteAll();
    }

    @Test
    public void testBuscarUsuarioPorLogin() {
        Assert.assertNotNull(dao.buscarUsuarioPorLogin(usuarioPadrao.getLogin()));
    }

    @Test
    public void testFindAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = dao.listAll();
        Assert.assertFalse(usuarios.isEmpty());
    }

    @Test
    public void testCountUsuarios() {
        int value = dao.count();
        Assert.assertFalse(value == 0);
    }

    @Test
    public void testSaveUsuario() {
        dao.save(usuarioTester);
        Assert.assertNotNull(dao.buscarUsuarioPorLogin(usuarioTester.getLogin()));
    }

    @Test
    public void testUpdateUsuario() {
        Usuario u = new Usuario();
        for (Usuario user : dao.listAll()) {
            if (!user.equals(usuarioPadrao)) {
                u = user;
                break;
            }
        }
        String newLogin = "usuarioUpdated";
        u.setLogin(newLogin);
        dao.update(u);
        u = dao.buscarUsuarioPorLogin(newLogin);
        Assert.assertNotNull(u);
        Assert.assertEquals(newLogin, u.getLogin());
    }

    @Test
    public void testMergeUsuario() {
        Usuario u = new Usuario();
        for (Usuario user : dao.listAll()) {
            if (!user.equals(usuarioPadrao)) {
                u = user;
                break;
            }
        }
        String newLogin = "usuarioMerged";
        u.setLogin(newLogin);
        dao.merge(u);
        u = dao.buscarUsuarioPorLogin(newLogin);
        Assert.assertNotNull(u);
        Assert.assertEquals(newLogin, u.getLogin());
    }

    @Test
    public void testDeleteUsuario() {
        Usuario u = dao.buscarUsuarioPorLogin(usuarioPadrao.getLogin());
        dao.delete(u);
        Assert.assertNull(dao.buscarUsuarioPorLogin(usuarioPadrao.getLogin()));
    }

    @Test
    public void testRecoverUsuario() {
        Usuario u = dao.listAll().get(0);
        Usuario recovered = dao.recover(Usuario.class, u.getId());
        Assert.assertNotNull(recovered);
        Assert.assertEquals(u, recovered);
    }

    @Test
    public void testFindById() {
        Usuario u = dao.listAll().get(0);
        Usuario finded = dao.findById(u.getId());
        Assert.assertNotNull(finded);
        Assert.assertEquals(u, finded);
    }
}
