
import br.com.fourthapp.connection.DatabaseConnection;
import javax.persistence.EntityManager;
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
//        em.getTransaction().begin();
//        Query q = (Query) em.createNamedQuery("pessoas.findAll", Pessoa.class);
//        List<Pessoa> pessoas = q.getResultList();
//        System.out.println("Pessoas: " + pessoas.size());
        assert em.isOpen();
    }
}
