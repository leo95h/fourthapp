package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.AssuntoDAOImpl;
import br.com.fourthapp.entity.Assunto;
import br.com.fourthapp.entity.fixture.AssuntoFixture;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fernando
 * @see Sevilha
 */
public class AssuntoTest {

    private static AssuntoDAOImpl dao;
    private static Assunto assuntoPadraoRaiz;
    private static Assunto assuntoTester;
    private static Set<Assunto> assuntos;

    public AssuntoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        dao = new AssuntoDAOImpl();
        assuntoPadraoRaiz = AssuntoFixture.assuntoPadrao();
        assuntoTester = AssuntoFixture.assunto("Programação");
        assuntos = AssuntoFixture.createTree(5, 4);
        populateDatabase();
    }

    @AfterClass
    public static void tearDownClass() {
//        cleanDatabase();
    }

    @Test
    public void testBuscarAssuntoPorNome() {
        Assert.assertNotNull(dao.buscarAssuntoPorNome(assuntoPadraoRaiz.getNome()));
    }

    @Test
    public void testBuscarAssuntosFilhos() {
        Assunto raiz = dao.buscarAssuntoPorNome(assuntoPadraoRaiz.getNome());
        List<Assunto> filhos = dao.buscarAssuntosFilhos(raiz);
        Assert.assertNotNull(filhos);
        Assert.assertFalse(filhos.isEmpty());
        Assert.assertEquals(4, filhos.size());
    }

    private static void populateDatabase() {
        cleanDatabase();
        for (Assunto a : assuntos) {
            if (a.getSuperior() == null && a.getId() == null) {
                if (a.getId() == null) {
                    a = dao.merge(a);
                }
                salvaFilhos(a.getAssuntos());
            }
        }
    }

    private static void salvaFilhos(Set<Assunto> filhos) {
        for (Assunto a : filhos) {
            if (a.getId() == null) {
                a = dao.merge(a);
                if (!a.getAssuntos().isEmpty()) {
                    salvaFilhos(a.getAssuntos());
                }
            }
        }
    }

    private static void cleanDatabase() {
        dao.deleteAll();
    }
}
