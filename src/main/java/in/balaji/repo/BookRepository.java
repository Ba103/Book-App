package in.balaji.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.balaji.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
