package swingGUI;

import br.com.loja.HibernateUtil;
import lojaConsole.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersistenciaDB {

    static List<Produto> carregarDB(){
        try{
            // Abre uma sessão
            Session session = HibernateUtil.getSessionFactory().openSession();

            //Pega todos os produtos do BANCO e transforma em objetos na lista
            List<Produto> produtosDB = session.createQuery("FROM Produto", Produto.class).list();

            // Fecha a sessão
            session.close();

            return produtosDB;

        }catch (HibernateException e){
            System.err.println("Erro ao carregar os produtos: " + e);
            return new ArrayList<>();
        }
    }

    static void salvarTodos(Collection<Produto> produtos) {

        // Abre uma sessão
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Inicia uma transação
        Transaction tx = session.beginTransaction();

        session.createQuery("DELETE FROM Produto").executeUpdate(); // apaga todos

        //Salva ou atualiza os dados
        for (Produto p : produtos) {
            session.saveOrUpdate(p);
        }

        // Comita a transação
        tx.commit();

        // Fecha a sessão
        session.close();
    }
}
