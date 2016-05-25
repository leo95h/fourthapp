/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fourthapp.tests.model;

import br.com.fourthapp.dao.impl.AvaliacaoDAOImpl;
import br.com.fourthapp.dao.impl.PublicacaoDAOImpl;
import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Avaliacao;
import br.com.fourthapp.entity.Publicacao;
import br.com.fourthapp.entity.Usuario;
import br.com.fourthapp.entity.fixture.UsuarioFixture;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author fernando
 * @see Mosconi
 */
public class AvaliacaoTest {
    
    private static UsuarioDAOImpl usuarioDao;
    private static Usuario usuario;
    
    private static PublicacaoDAOImpl publicacaoDao;
    private static Publicacao publicacao;
    
    private static AvaliacaoDAOImpl avaliacaoDao;
    private static Avaliacao avaliacao;
    private static Avaliacao avaliacaoTester;
    private static List<Avaliacao> avaliacoes;
    
    
    public AvaliacaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        usuarioDao = new UsuarioDAOImpl();
        usuario = UsuarioFixture.usuarioPadrao();
        
        publicacaoDao = new PublicacaoDAOImpl();
        
        
        avaliacaoDao = new AvaliacaoDAOImpl();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
}
