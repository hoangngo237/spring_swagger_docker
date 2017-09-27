package com.book.dao;

import java.util.List;

import com.book.entity.Book;

public interface IBookDAO {
	List<Book> getAllBooks();
	
	Book bookById(int Id);
	
	void addBook(Book book);
	
	void updateBook(Book book);
}
