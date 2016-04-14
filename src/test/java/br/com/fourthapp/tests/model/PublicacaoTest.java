/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fourthapp.tests.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import br.com.fourthapp.dao.impl.PublicacaoDAOImpl;
import br.com.fourthapp.entity.Publicacao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Emerson Del Coli
 * @see Emerson
 */
public class PublicacaoTest {

    private static PublicacaoDAOImpl dao;
    private static Publicacao publicacao;

    public PublicacaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dao = new PublicacaoDAOImpl();
        Date dataPublicacao = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataPublicacao);
        publicacao = new Publicacao("O dia depois de amanha", cal, "O dia depois de amanha é sabado", null, null, null);

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
        Publicacao p = dao.buscarPublicacaoPorNome(publicacao.getNome());
        if (p == null) {
            p = dao.merge(publicacao);
        }
        Assert.assertNotNull(p);
    }

    @Test
    public void findAllPublicacao() {
        List<Publicacao> publicacoes = new ArrayList<Publicacao>();
        publicacoes = dao.listAll();
        Assert.assertFalse(publicacoes.isEmpty());
    }

    @Test
    public void countPublicacao() {
        int value = dao.count();
        Assert.assertFalse(value == 0);
    }

}
