package hibernate;

import hibernate.entity.Author;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

public class Start {


    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        var author = session.get(Author.class,1L);
        System.out.println(author.toString());
        System.out.println();

        var criteriaQuery = session.getCriteriaBuilder().createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        criteriaQuery.select(root);
        var query = session.createQuery(criteriaQuery);
        var authorList = query.getResultList();
        System.out.println(authorList.toString());

    }
}
