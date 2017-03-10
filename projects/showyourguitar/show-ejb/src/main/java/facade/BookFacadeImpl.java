package facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import domain.BookCategoryStub;
import domain.BookCriteria;
import domain.BookStub;

@Stateless
public class BookFacadeImpl implements BookFacade {

	@Override
	public BookStub getBook(String isbn) {
		return new BookStub("978-0441172719", "Frank Herbert", "Dune", BookCategoryStub.SCIFI,
				3500.0, 896);
	}

	@Override
	public List<BookStub> getBooks(BookCriteria criteria) {
		List<BookStub> stubs = new ArrayList<>();
		stubs.add(new BookStub("978-0441172719", "Frank Herbert", "Dune", BookCategoryStub.SCIFI,
				3500.0, 896));
		return stubs;
	}

}
