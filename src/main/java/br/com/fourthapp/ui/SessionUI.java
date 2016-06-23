package br.com.fourthapp.ui;

import br.com.fourthapp.dao.impl.UsuarioDAOImpl;
import br.com.fourthapp.entity.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import static br.com.fourthapp.util.Criptografia.encriptar;
import static br.com.fourthapp.util.Util.hasText;

/**
 *
 * @author fernando
 */
@ManagedBean(name = "sessionUI")
@SessionScoped
public class SessionUI {

    private String login;
    private String senha;
    private Usuario usuario;
    private final UsuarioDAOImpl usuarioDAO;

    public SessionUI() {
        this.usuario = new Usuario();
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    public String doLogin() {
        if (hasText(login) && hasText(senha)) {
            this.usuario = usuarioDAO.buscarUsuarioPorLoginESenha(login, encriptar(senha));
            this.login = "";
            this.senha = "";
            return "/pages/timeline";
        }
        return "";
    }

    public String novoUsuario() {
        return "";
    }
    
    public String doLogout() {
        this.usuario = new Usuario();
        this.login = "";
        this.senha = "";
        return "/index";
    }

    public boolean isLogged() {
        return this.usuario.getId() != null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
