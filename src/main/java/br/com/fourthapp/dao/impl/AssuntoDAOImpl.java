package br.com.fourthapp.dao.impl;

import br.com.fourthapp.dao.AbstractDAO;
import br.com.fourthapp.dao.AssuntoDAO;
import br.com.fourthapp.entity.Assunto;
import java.util.List;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public class AssuntoDAOImpl extends AbstractDAO<Assunto> implements AssuntoDAO {

    public AssuntoDAOImpl() {
        super(Assunto.class);
    }

    @Override
    public Assunto buscarAssuntoPorNome(String nome) {
        Query q = getEntityManager().createNamedQuery("Assunto.findByNome", Assunto.class);
        q.setParameter("nome", nome);
        List<Assunto> assuntos = q.getResultList();
        if (assuntos.size() > 1) {
            throw new NonUniqueResultException();
        } else if (assuntos.size() == 1) {
            return assuntos.get(0);
        }
        return null;
    }

    @Override
    public List<Assunto> buscarAssuntosFilhos(Assunto assunto) {
        Query q = getEntityManager().createNamedQuery("Assunto.findBySuperior", Assunto.class);
        q.setParameter("superior", assunto);
        return q.getResultList();
    }

}
