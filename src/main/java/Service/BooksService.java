package Service;

import java.util.ArrayList;

import EntityMapping.Books;

public interface BooksService {

	public ArrayList<Books> getList(int page);

	public Books insert(Books book);

	public Books update(Books book);

	public Books delete(Books book);

}
