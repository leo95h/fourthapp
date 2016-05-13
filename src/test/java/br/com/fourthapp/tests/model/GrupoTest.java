/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.GrupoDAOImpl;
import br.com.fourthapp.entity.Grupo;
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
 * @see Larissa
 */
public class GrupoTest {

    private static GrupoDAOImpl dao;
    private static Grupo grupo;

    public GrupoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dao = new GrupoDAOImpl();
        grupo = new Grupo("Computação");
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
        Grupo g = dao.buscarGrupoPorNome(grupo.getNome());
        if (g == null) {
            g = dao.merge(grupo);
        }
        Assert.assertNotNull(g);
    }
    
    @Test
    public void testBuscarGrupoPorNome() {
        Assert.assertNotNull(dao.buscarGrupoPorNome(grupo.getNome()));
    }

    @Test
    public void testFindAllGrupos() {
        List<Grupo> grupos = new ArrayList<Grupo>();
        grupos = dao.listAll();
        Assert.assertFalse(grupos.isEmpty());
    }

    @Test
    public void testCountGrupos() {
        int value = dao.count();
        Assert.assertFalse(value == 0);
    }

    @Test
    public void testRecoverGrupo() {
        Grupo g = dao.listAll().get(0);
        Grupo recovered = dao.recover(Grupo.class, g.getId());
        Assert.assertNotNull(recovered);
        Assert.assertEquals(g, recovered);
    }

    @Test
    public void testFindById() {
        Grupo g = dao.listAll().get(0);
        Grupo finded = dao.findById(g.getId());
        Assert.assertNotNull(finded);
        Assert.assertEquals(g, finded);
    }
}
