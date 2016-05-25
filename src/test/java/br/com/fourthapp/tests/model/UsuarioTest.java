package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Usuario;
import br.com.fourthapp.entity.fixture.UsuarioFixture;
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
    private static List<Usuario> usuarios;
    private static final int BUCKET_USUARIOS = 10;

    public UsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dao = new UsuarioDAOImpl();
        usuarioPadrao = UsuarioFixture.usuarioPadrao();
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
        Assert.assertNotNull(dao.buscarUsuarioPorLogin(usuarios.get(0).getLogin()));
    }

    @Test
    public void testFindAllUsuarios() {
        Assert.assertFalse(dao.listAll().isEmpty());
    }

    @Test
    public void testCountUsuarios() {
        Assert.assertFalse(dao.count() == 0);
    }

    @Test
    public void testSaveUsuario() {
        dao.save(usuarioPadrao);
        Assert.assertNotNull(dao.buscarUsuarioPorLogin(usuarioPadrao.getLogin()));
    }

    @Test
    public void testUpdateUsuario() {
        Usuario u = usuarios.get(0);
        String newLogin = "usuarioUpdated";
        u.setLogin(newLogin);
        dao.update(u);
        u = dao.buscarUsuarioPorLogin(newLogin);
        Assert.assertNotNull(u);
        Assert.assertEquals(newLogin, u.getLogin());
    }

    @Test
    public void testMergeUsuario() {
        Usuario u = usuarios.get(0);
        String newLogin = "usuarioMerged";
        u.setLogin(newLogin);
        dao.merge(u);
        u = dao.buscarUsuarioPorLogin(newLogin);
        Assert.assertNotNull(u);
        Assert.assertEquals(newLogin, u.getLogin());
    }

    @Test
    public void testDeleteUsuario() {
        Usuario u = usuarios.get(0);
        dao.delete(u);
        Assert.assertNull(dao.buscarUsuarioPorLogin(u.getLogin()));
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
