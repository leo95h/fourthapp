package br.com.fourthapp.dao.impl;

import br.com.fourthapp.dao.PublicacaoDAO;
import br.com.fourthapp.entity.Publicacao;
import br.com.fourthapp.dao.AbstractDAO;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.NonUniqueResultException;

/**
 *
 * @author Emerson Del Coli
 */
public class PublicacaoDAOImpl extends AbstractDAO<Publicacao> implements PublicacaoDAO {

    public PublicacaoDAOImpl() {
        super(Publicacao.class);
    }

    @Override
    public List<Publicacao> ListarNomePublicacao(String nome) {
        Query q = getEntityManager().createNamedQuery("Publicacao.findByNome", Publicacao.class);
        q.setParameter("nome", nome);
        return q.getResultList();
    }

    public Publicacao buscarPublicacaoPorNome(String nome) {
        Query q = getEntityManager().createNamedQuery("Publicacao.findByNome", Publicacao.class);
        q.setParameter("nome", nome);
        List<Publicacao> publicacoes = q.getResultList();
        if (publicacoes.isEmpty()) {
            return null;
        }
        if (publicacoes.size() == 1) {
            return publicacoes.get(0);
        } else {
            throw new NonUniqueResultException();
        }
    }
}
