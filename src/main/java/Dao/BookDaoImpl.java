package Dao;

import java.util.ArrayList;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import EntityMapping.Books;

@Repository
public class BookDaoImpl extends AbstractDao implements BookDao {

	@Override
	public ArrayList<Books> getList(int page) {
		
		String hql = "from Books";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(page * 3);
		query.setMaxResults(page * 3 + 3);
		@SuppressWarnings("unchecked")
		ArrayList<Books> list = (ArrayList<Books>) query.list();
		for (Books books : list) {
			System.out.println(" Name " + books.getName());
		}
		return list;
	}

	/* Insert book into DB */
	@Override
	public Books insert(Books book) {
		getSession().persist(book);
		return book;
	}

	/* Update book to database */
	@Override
	public Books update(Books book) {
		//getSession().update(book);
		getSession().saveOrUpdate(book);
		return book;
	}

	/* Delete book in DB */
	@Override
	public Books delete(Books book) {
		getSession().delete(book);
		return book;
	}

}
