package in.balaji;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import in.balaji.entity.Book;
import in.balaji.repo.BookRepository;
import in.balaji.service.BookService;

public class BookServiceTest {

	@InjectMocks
	private BookService bookService;

	@InjectMocks
	private BookRepository bookRepo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllBooks() {
		// Mock data
		List<Book> mockBooks = Arrays.asList(new Book(1, "Balaji", "Java", 4350.00),
				new Book(2, "Jagadeesh", "Python", 2350.00));

		// Mock repository
		when(bookRepo.findAll()).thenReturn(mockBooks);

		// Call service method
		List<Book> books = bookService.getAll();

		// Verify results
		assertEquals(2, books.size());
		verify(bookRepo, times(1)).findAll();
	}

}
