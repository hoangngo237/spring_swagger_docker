package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface IBookService {
	List<Book> getAllBooks();
	
	Book getBookById(int id);
	
	void insertBook(Book book);
	
	void updateBook(Book book);
}
