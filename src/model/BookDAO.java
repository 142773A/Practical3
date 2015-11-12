package model;

import demo.BookDetails;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;

/**
 * Created by 142773A on 11/12/2015.
 */
public class BookDAO {
    private Random random = new Random();
    private EntityManager em;

    public BookDAO(){
        em = EMF.get().createEntityManager();
    }

    public BooksEntity getBook(){
        List<BooksEntity> list = getAllBook();
        int i = random.nextInt(list.size());
        return list.get(i);
    }

    public List<BooksEntity> getAllBook() {
        List<BooksEntity> list = null;
        try {
            Query query = em.createQuery("select b from BooksEntity b");
            list = query.getResultList();

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public BooksEntity getBookDetails(String bookId){

        BooksEntity bookDetail = null;

        try {
            Query query = em.createQuery("select d from BooksEntity d where d.id = '" + bookId + "'");
            bookDetail = (BooksEntity) query.getSingleResult();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return bookDetail;
    }
}
