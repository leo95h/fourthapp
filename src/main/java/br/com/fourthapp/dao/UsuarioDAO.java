package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Usuario;

/**
 *
 * @author fernando
 */
public interface UsuarioDAO {

    public Usuario buscarUsuarioPorLogin(String login);
}
