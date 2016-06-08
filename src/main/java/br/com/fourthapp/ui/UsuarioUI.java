package br.com.fourthapp.ui;

import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author fernando
 */
@ManagedBean(name = "usuarioUI")
@SessionScoped
public class UsuarioUI {

    private Usuario usuario;
    private final UsuarioDAOImpl dao;

    public UsuarioUI() {
        usuario = new Usuario();
        dao = new UsuarioDAOImpl();
    }

    public String novo() {
        usuario = new Usuario();
        return "edita";
    }

    public String salvar() {
        dao.save(usuario);
        return "lista";
    }

    public String cancelar() {
        usuario = new Usuario();
        return "lista";
    }

    public String editar(Usuario usuario) {
        this.usuario = usuario;
        return "edita";
    }

    public String excluir(Usuario usuario) {
        dao.delete(usuario);
        return "lista";
    }

    public List<Usuario> getListaTodos() {
        return dao.listAll();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
