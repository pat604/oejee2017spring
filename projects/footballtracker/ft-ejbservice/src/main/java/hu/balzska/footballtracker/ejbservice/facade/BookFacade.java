package hu.balzska.footballtracker.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.balzska.footballtracker.ejbservice.domain.BookCriteria;
import hu.balzska.footballtracker.ejbservice.domain.BookStub;
import hu.balzska.footballtracker.ejbservice.exception.FacadeException;

@Local
public interface BookFacade {

	BookStub getBook(String isbn) throws FacadeException;

	List<BookStub> getBooks(BookCriteria criteria) throws FacadeException;

}
