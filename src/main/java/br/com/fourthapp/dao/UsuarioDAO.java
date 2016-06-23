package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Usuario;

/**
 *
 * @author fernando
 */
public interface UsuarioDAO {

    Usuario buscarUsuarioPorLogin(String login);
    
    Usuario buscarUsuarioPorLoginESenha(String login, String senha);
}
