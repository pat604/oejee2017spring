package hu.qwaevisz.tickethandling.persistence.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hu.qwaevisz.bookstore.persistence.entity.Book;
import hu.qwaevisz.bookstore.persistence.entity.trunk.BookCategory;
import hu.qwaevisz.bookstore.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.tickethandling.persistence.entity.Ticket;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Priority;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Status;

public class TicketServiceImplIntegrationTest {

	private static final String PERSISTENCE_UNIT = "th-persistence-test-unit";

	private static final String NEW_BOOK_ISBN = "42-NEW-BOOK-ISBN";

	private BookServiceImpl object;

	@BeforeClass
	private void setUp() {
		Thread.currentThread().setContextClassLoader(new ClassLoader() {
			@Override
			public Enumeration<URL> getResources(String name) throws IOException {
				if (name.equals("META-INF/persistence.xml")) {
					return Collections.enumeration(Arrays.asList(new File("src/test/resources/persistence.xml").toURI().toURL()));
				}
				return super.getResources(name);
			}
		});

		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		final EntityManager entityManager = factory.createEntityManager();

		this.object = new TicketServiceImpl();
		this.object.setEntityManager(entityManager);
	}

	@Test(groups = "integration")
	private void readSampleTicketFromDatabase() throws PersistenceServiceException {
		final Ticket ticket = this.object.read("AES-324-201703160515");
		this.assertTicket(ticket, "AES-324-201703160515", Priority.HIGH, Status.IN_PROGRESS);
	}

	private void assertBook(final Ticket ticket, final String id, final Priority priority, final Status status) {
		Assert.assertEquals(ticket.getId(), id);
		Assert.assertEquals(ticket.getPriority(), priority);
		Assert.assertEquals(ticket.getStatus(), status);
	}
	/*
	@Test(groups = "integration")
	private void createABook() throws PersistenceServiceException {
		if (this.object.exists(NEW_BOOK_ISBN)) {
			this.object.getEntityManager().getTransaction().begin();
			this.object.delete(NEW_BOOK_ISBN);
			this.object.getEntityManager().getTransaction().commit();
		}

		this.object.getEntityManager().getTransaction().begin();
		this.object.create(NEW_BOOK_ISBN, "Lorem Ipsum", "Sample book", 142, 999, BookCategory.HISTORICAL);
		this.object.getEntityManager().getTransaction().commit();

		final Book book = this.object.read(NEW_BOOK_ISBN);
		this.assertBook(book, NEW_BOOK_ISBN, "Lorem Ipsum", "Sample book", BookCategory.HISTORICAL, 142, 999);
	}
	*/
	@AfterClass
	private void tearDown() {
		this.object.getEntityManager().close();
	}

}
