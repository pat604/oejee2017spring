package facade;

import java.util.List;

import javax.ejb.Local;

import domain.BookCriteria;
import domain.BookStub;

@Local
public interface BookFacade {

	BookStub getBook(String isbn);

	List<BookStub> getBooks(BookCriteria criteria);

}
