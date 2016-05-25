package br.com.fourthapp.dao.impl;

import br.com.fourthapp.dao.AbstractDAO;
import br.com.fourthapp.dao.GrupoDAO;
import br.com.fourthapp.entity.Grupo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public class GrupoDAOImpl extends AbstractDAO<Grupo> implements GrupoDAO {

    public GrupoDAOImpl() {
        super(Grupo.class);
    }

    @Override
    public Grupo buscarGrupoPorNome(String nome) {
        Query q = getEntityManager().createNamedQuery("Grupo.findByNome", Grupo.class);
        q.setParameter("nome", nome);
        List<Grupo> grupos = q.getResultList();
        if (grupos.size() == 1) {
            return grupos.get(0);
        } else {
            for (Grupo gp : grupos) {
                System.out.println(gp.getNome());
            }
//            throw new NonUniqueResultException();
            return null;
        }
    }

}
