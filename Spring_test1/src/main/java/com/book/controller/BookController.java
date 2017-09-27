package com.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.entity.Book;
import com.book.service.IBookService;

@Controller
@RequestMapping("api")
public class BookController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private IBookService bookService;

	@GetMapping("example")
	public ResponseEntity<Book> example() {
		
		LOGGER.info("Start example");
		Book book = new Book();
		book.setId(1000);
		book.setCode("Example");
		book.setName("example");
		LOGGER.info("Finish example");
		return new ResponseEntity<Book>(book, HttpStatus.OK);

	}

	@GetMapping("books")
	public ResponseEntity<List<Book>> getAllBooks() {
		LOGGER.info("Start get books information");
		List<Book> list = bookService.getAllBooks();
		LOGGER.info("Get books information finish");
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}

	@GetMapping("book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		LOGGER.info("Start find book by id");
		try {
			Book outBook = bookService.getBookById(id);
			LOGGER.info("Find book by id finish");
			return new ResponseEntity<Book>(outBook, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.info("Find book by id fail");
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("book/add")
	public ResponseEntity<HttpStatus> addBook(@RequestBody Book book) {
		try {
			LOGGER.info("Inserting book...");
			bookService.insertBook(book);
			LOGGER.info("Insert book finish");
		} catch (Exception ex) {
			LOGGER.info("Insert book fail");
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PostMapping("book/update")
	public ResponseEntity<HttpStatus> updateBook(@RequestBody Book book) {
		try {
			LOGGER.info("Updating book...");
			bookService.updateBook(book);
			LOGGER.info("Update book finish");
		} catch (Exception ex) {
			LOGGER.info("Update book fail");
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

}
