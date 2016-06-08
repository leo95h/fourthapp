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
import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Publicacao;
import br.com.fourthapp.entity.Usuario;
import br.com.fourthapp.entity.fixture.UsuarioFixture;
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

    private static UsuarioDAOImpl usuarioDao;
    private static Usuario usuario;
    
    private static PublicacaoDAOImpl publicacaoDao;
    private static Publicacao publicacao;

    public PublicacaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        usuarioDao = new UsuarioDAOImpl();
        usuario = UsuarioFixture.usuarioPadrao();
        
        publicacaoDao = new PublicacaoDAOImpl();
        Date dataPublicacao = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataPublicacao);
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

//    @Test
//    public void persistIfNotExists() {
//        Publicacao p = publicacaoDao.buscarPublicacaoPorNome(publicacao.getNome());
//        if (p == null) {
//            p = publicacaoDao.merge(publicacao);
//        }
//        Assert.assertNotNull(p);
//    }
//
//    @Test
//    public void findAllPublicacao() {
//        List<Publicacao> publicacoes = new ArrayList<>();
//        publicacoes = publicacaoDao.listAll();
//        Assert.assertFalse(publicacoes.isEmpty());
//    }
//
//    @Test
//    public void countPublicacao() {
//        int value = publicacaoDao.count();
//        Assert.assertFalse(value == 0);
//    }

}
