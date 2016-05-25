package br.com.fourthapp.dao.impl;

import br.com.fourthapp.dao.AbstractDAO;
import br.com.fourthapp.dao.AvaliacaoDAO;
import br.com.fourthapp.entity.Avaliacao;
import br.com.fourthapp.entity.Publicacao;
import br.com.fourthapp.entity.TipoAvaliacao;
import br.com.fourthapp.entity.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public class AvaliacaoDAOImpl extends AbstractDAO<Avaliacao> implements AvaliacaoDAO {

    public AvaliacaoDAOImpl() {
        super(Avaliacao.class);
    }

    @Override
    public List<Avaliacao> buscarAvaliacoesPorPublicacao(Publicacao publicacao) {
        Query q = getEntityManager().createNamedQuery("Avaliacao.findByPublicacao", Avaliacao.class);
        q.setParameter("publicacao", publicacao);
        return q.getResultList();
    }

    @Override
    public List<Avaliacao> buscarAvaliacoesPorUsuario(Usuario usuario) {
        Query q = getEntityManager().createNamedQuery("Avaliacao.findByUsuario", Avaliacao.class);
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }

    @Override
    public List<Avaliacao> buscarAvaliacoesPorTipo(TipoAvaliacao tipoAvaliacao) {
        Query q = getEntityManager().createNamedQuery("Avaliacao.findByTipo", Avaliacao.class);
        q.setParameter("tipoAvaliacao", tipoAvaliacao);
        return q.getResultList();
    }

}
