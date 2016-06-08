/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.GrupoDAOImpl;
import br.com.fourthapp.entity.Grupo;
import br.com.fourthapp.entity.fixture.GrupoFixture;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fernando
 * @see Larissa
 */
public class GrupoTest {

    private static final int BUCKET_GRUPOS = 10;
    private static GrupoDAOImpl dao;
    private static Grupo grupoPadrao;
    private static Grupo grupoTester;
    private static List<Grupo> grupos;

    public GrupoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dao = new GrupoDAOImpl();
        grupoPadrao = GrupoFixture.grupoPadrao();
        grupoTester = GrupoFixture.novoGrupo("Computação");
        grupos = GrupoFixture.grupos(BUCKET_GRUPOS);
        populateDatabase();
    }

    @AfterClass
    public static void tearDownClass() {
        //cleanDatabase();
    }

    private static void populateDatabase() {
        cleanDatabase();
        for (Grupo gr : grupos) {
            if (dao.buscarGrupoPorNome(gr.getNome()) == null) {
                dao.save(gr);
            }
        }
    }

    private static void cleanDatabase() {
        dao.deleteAll();
    }

//    @Test
//    public void testBuscarGrupoPorNome() {
//        Assert.assertNotNull(dao.buscarGrupoPorNome(grupoPadrao.getNome()));
//    }
//
//    @Test
//    public void testFindAllGrupos() {
//        Assert.assertFalse(dao.listAll().isEmpty());
//    }
//
//    @Test
//    public void testCountGrupos() {
//        Assert.assertFalse(dao.count() == 0);
//    }
//
//    @Test
//    public void testSaveGrupo() {
//        dao.save(grupoTester);
//        Assert.assertNotNull(dao.buscarGrupoPorNome(grupoTester.getNome()));
//    }
//
//    @Test
//    public void testUpdateGrupo() {
//        Grupo gr = new Grupo();
//        for (Grupo gru : dao.listAll()) {
//            if (!gru.equals(grupoPadrao)) {
//                gr = gru;
//                break;
//            }
//        }
//        String novoNome = "Grupo atualizado";
//        gr.setNome(novoNome);
//        dao.update(gr);
//        gr = dao.buscarGrupoPorNome(novoNome);
//        Assert.assertNotNull(gr);
//        Assert.assertEquals(novoNome, gr.getNome());
//    }
//
//    @Test
//    public void testMergeGrupo() {
//        Grupo gr = new Grupo();
//        for (Grupo gru : dao.listAll()) {
//            if (!gru.equals(grupoPadrao)) {
//                gr = gru;
//                break;
//            }
//        }
//        String novoNome = "Grupo mesclado";
//        gr.setNome(novoNome);
//        gr = dao.merge(gr);
//        Assert.assertNotNull(gr);
//        Assert.assertEquals(novoNome, gr.getNome());
//    }
//    
//    @Test
//    public void testDeleteGrupo() {
//        Grupo gr = dao.buscarGrupoPorNome(grupoPadrao.getNome());
//        dao.delete(gr);
//        Assert.assertNull(dao.buscarGrupoPorNome(grupoPadrao.getNome()));
//    }
//    
//    @Test
//    public void testRecoverGrupo() {
//        Grupo g = dao.listAll().get(0);
//        Grupo recovered = dao.recover(Grupo.class, g.getId());
//        Assert.assertNotNull(recovered);
//        Assert.assertEquals(g, recovered);
//    }
//
//    @Test
//    public void testFindById() {
//        Grupo g = dao.listAll().get(0);
//        Grupo finded = dao.findById(g.getId());
//        Assert.assertNotNull(finded);
//        Assert.assertEquals(g, finded);
//    }
}
