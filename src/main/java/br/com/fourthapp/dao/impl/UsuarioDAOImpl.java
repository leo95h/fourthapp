package br.com.fourthapp.dao.impl;

import br.com.fourthapp.dao.AbstractDAO;
import br.com.fourthapp.dao.UsuarioDAO;
import br.com.fourthapp.entity.Usuario;
import java.util.List;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    @Override
    public Usuario buscarUsuarioPorLogin(String login) {
        Query q = getEntityManager().createNamedQuery("Usuario.findByLogin", Usuario.class);
        q.setParameter("login", login);
        List<Usuario> usuarios = q.getResultList();
        if (usuarios.isEmpty()) {
            return null;
        }
        if (usuarios.size() == 1) {
            return usuarios.get(0);
        } else {
            throw new NonUniqueResultException();
        }
    }

}
