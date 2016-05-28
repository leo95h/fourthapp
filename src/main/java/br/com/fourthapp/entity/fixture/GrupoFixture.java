package br.com.fourthapp.entity.fixture;

import br.com.fourthapp.entity.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class GrupoFixture {

    private static final String NOME = "Grupo";

    public static Grupo grupoPadrao() {
        return newGrupo(NOME + " Padrão");
    }

    public static Grupo novoGrupo(String nome) {
        return newGrupo(nome);
    }

    public static List<Grupo> grupos(int size) {
        List<Grupo> grupos = new ArrayList<>();
        if (size <= 0) {
            return grupos;
        }
        for (int x = 1; x < size; x++) {
            grupos.add(newGrupo(NOME + x));
        }
        grupos.add(grupoPadrao());
        return grupos;
    }

    private static Grupo newGrupo(String nome) {
        return new Grupo(nome);
    }

}
