/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.fourthapp.connection.DatabaseConnection;
import br.com.fourthapp.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class ConnectionTest {

    public ConnectionTest() {
    }

    @Test
    public void connection() {
        EntityManager em = DatabaseConnection.createInstance().getEntityManager();
        em.getTransaction().begin();
        Query q = (Query) em.createNamedQuery("pessoas.findAll", Pessoa.class);
        List<Pessoa> pessoas = q.getResultList();
        System.out.println("Pessoas: " + pessoas.size());
    }
}
