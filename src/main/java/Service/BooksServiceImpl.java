package Service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.BookDao;
import EntityMapping.Books;

@Service
@Transactional
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BookDao bookDao;

	@Override
	public ArrayList<Books> getList(int page) {
		return this.bookDao.getList(page);
	}

	@Override
	public Books insert(Books book) {
		// TODO Auto-generated method stub@Transactional
		return this.bookDao.insert(book);
	}

	@Override
	public Books update(Books book) {
		// TODO Auto-generated method stub
		return this.bookDao.update(book);
	}

	@Override
	public Books delete(Books book) {
		// TODO Auto-generated method stub
		return this.bookDao.delete(book);
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
