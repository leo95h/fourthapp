/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fourthapp.entity.fixture;

import br.com.fourthapp.entity.Assunto;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author fernando
 */
public class AssuntoFixture {

    private static final String NOME_PADRAO = "Informática";
    private static final Set<Assunto> assuntos = new HashSet<>();

    public static Assunto assuntoPadrao() {
        return newAssunto(NOME_PADRAO, null);
    }

    public static Assunto assunto(String nome) {
        return newAssunto(nome, null);
    }

    public static Assunto assuntoPadrao(Assunto superior) {
        return newAssunto(NOME_PADRAO, superior);
    }

    public static Assunto assunto(String nome, Assunto superior) {
        return newAssunto(nome, superior);
    }

    private static Assunto newAssunto(String nome, Assunto superior) {
        return new Assunto(nome, superior);
    }

    public static Set<Assunto> createTree(int size, int levels) {
        Assunto raiz = assuntoPadrao();
        assuntos.add(raiz);
        for (int x = 1; x <= levels; x++) {
            String nome = "Level " + x;
            Assunto pai = assunto(nome, raiz);
            assuntos.add(pai);
            for (int y = 1; y <= size; y++) {
                Assunto filho = assunto(nome + "." + y, pai);
                assuntos.add(filho);
            }
        }
        return assuntos;
    }
}
