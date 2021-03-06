package br.com.fourthapp.entity.fixture;

import br.com.fourthapp.entity.Pessoa;
import br.com.fourthapp.entity.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fernando
 */
public class UsuarioFixture {

    private static final String DOMAIN = "@fourthapp.com.br";
    private static final String LOGIN = "fernando";
    private static final String PASSWORD = "senha";

    public static Usuario usuarioPadrao() {
        return novoUsuario(LOGIN, PASSWORD);
    }

    public static Usuario usuarioByLogin(String login) {
        return novoUsuario(login, PASSWORD);
    }

    public static Usuario usuarioByPassword(String password) {
        return novoUsuario(LOGIN, password);
    }

    public static List<Usuario> usuarios(int size) {
        List<Usuario> usuarios = new ArrayList<>();
        if (size <= 0) {
            return usuarios;
        }
        for (int x = 1; x <= size; x++) {
            String login = LOGIN + x;
            String password = PASSWORD + x;
            usuarios.add(novoUsuario(login, password));
        }
//        usuarios.add(usuarioPadrao());
        return usuarios;
    }

    public static Usuario novoUsuario(String login, String password) {
        Usuario u = new Usuario(login + DOMAIN, password);
        Pessoa p = new Pessoa(login, login, new Date());
        u.setPessoa(p);
        return u;
    }
}
