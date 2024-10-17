package in.balaji.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.balaji.entity.Book;
import in.balaji.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book upsert(Book book) {

		return bookRepo.save(book);
	}

	@Override
	public Book getBook(Integer id) {
		Optional<Book> findBook = bookRepo.findById(id);
		if (findBook.isPresent()) {
			return findBook.get();
		}
		return null;
	}

	@Override
	public List<Book> getAll() {

		return bookRepo.findAll();
	}

	@Override
	public String deleteBook(Integer id) {
		if (bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			return "successfully deleted";
		} else {
			return "Book not avaliable";
		}

	}

}
