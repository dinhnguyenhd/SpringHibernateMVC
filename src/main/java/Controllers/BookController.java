package Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import EntityMapping.Books;
import Service.BooksService;

//@Controller
@RestController
public class BookController {
	@Autowired
	private BooksService booksService;


	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Books>> getList(@PathVariable("page") int page) {
		ArrayList<Books> list = booksService.getList(page);
		return new ResponseEntity<ArrayList<Books>>(list, HttpStatus.OK);

	}

	// insert book into database
	@RequestMapping(value = "/book/insert", method = RequestMethod.POST)
	public Books insert(@RequestBody Books book) {
		System.out.println(" Books name " + book.getName() + "Id " + book.getId());
		return this.booksService.insert(book);

	}

	// insert book into database
	@RequestMapping(value = "/book/update", method = RequestMethod.PUT)
	public Books update(@RequestBody Books book) {
		System.out.println(" Books name " + book.getName() + "Id " + book.getId());
		return this.booksService.update(book);

	}

	// insert book into database
	@RequestMapping(value = "/book/delete", method = RequestMethod.DELETE)
	public Books delete(@RequestBody Books book) {
		System.out.println(" Books name " + book.getName() + "Id " + book.getId());
		return this.booksService.delete(book);

	}

	public BooksService getBooksService() {
		return booksService;
	}

	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

}
