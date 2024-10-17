package in.balaji.service;

import java.util.List;

import in.balaji.entity.Book;

public interface BookService {
	
	public Book upsert(Book book);
	
	public Book getBook(Integer id);
	
	public List<Book> getAll();
	
	public String deleteBook(Integer id);

}
