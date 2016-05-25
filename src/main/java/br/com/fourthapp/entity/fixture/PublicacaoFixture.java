/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fourthapp.entity.fixture;

import br.com.fourthapp.entity.Publicacao;
import br.com.fourthapp.entity.Usuario;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author fernando
 */
public class PublicacaoFixture {

    private static final String NOME_PADRAO = "Publicação";
    private static final String TEXTO_PADRAO = "Loren ipsum dollar";

    public static Publicacao newPublicacao(Usuario usuario) {
        return newPublicacao(NOME_PADRAO, getCalendarInstance(), TEXTO_PADRAO, usuario);
    }

    public static Publicacao newPublicacao(String nome, String texto, Usuario usuario) {
        return newPublicacao(nome, getCalendarInstance(), texto, usuario);
    }

    private static Publicacao newPublicacao(String nome, Calendar dataPublicacao, String texto, Usuario usuario) {
        return new Publicacao(nome, dataPublicacao, texto, usuario);
    }

    private static Calendar getCalendarInstance() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c;
    }
}
