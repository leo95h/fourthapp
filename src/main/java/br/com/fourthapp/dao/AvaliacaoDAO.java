package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Avaliacao;
import br.com.fourthapp.entity.Publicacao;
import br.com.fourthapp.entity.TipoAvaliacao;
import br.com.fourthapp.entity.Usuario;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface AvaliacaoDAO {

    public List<Avaliacao> buscarAvaliacoesPorPublicacao(Publicacao publicacao);
    
    public List<Avaliacao> buscarAvaliacoesPorUsuario(Usuario usuario);
    
    public List<Avaliacao> buscarAvaliacoesPorTipo(TipoAvaliacao tipoAvaliacao);
}
