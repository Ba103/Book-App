package in.balaji.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.balaji.entity.Book;
import in.balaji.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService service;

	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book status = service.upsert(book);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
		Book book = service.getBook(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = service.getAll();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@PutMapping("/book")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		Book upsert = service.upsert(book);
		upsert.setBookName("Java");
		upsert.setAuthor("Ravi");
		upsert.setPrice(2300.00);
		return new ResponseEntity<>(upsert, HttpStatus.OK);
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer id) {
		String deleteBook = service.deleteBook(id);
		return new ResponseEntity<>(deleteBook, HttpStatus.OK);

	}

}
