package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.IBookDAO;
import com.book.entity.Book;

@Service
public class BookService implements IBookService{

	@Autowired
	private IBookDAO bookDAO;
	
	public List<Book> getAllBooks() {
		
		return bookDAO.getAllBooks();
	}

	public Book getBookById(int id) {
		
		return bookDAO.bookById(id);
	}

	public void insertBook(Book book) {
		bookDAO.addBook(book);
		
	}

	public void updateBook(Book book) {
		bookDAO.updateBook(book);
		
	}
	
	

}
