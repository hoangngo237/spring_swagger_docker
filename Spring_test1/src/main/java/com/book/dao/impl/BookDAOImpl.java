package com.book.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.dao.IBookDAO;
import com.book.entity.Book;

@Transactional
@Repository
public class BookDAOImpl implements IBookDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
		String hql = "FROM Book as b ORDER BY b.id";
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}

	public Book bookById(int id) {
		String hql = "FROM Book as b WHERE b.id = ?";

		return (Book) entityManager.createQuery(hql).setParameter(1, id).getSingleResult();
	}

	public void addBook(Book book) {
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();
	}

	public void updateBook(Book book) {
		Book editBook = entityManager.find(Book.class, book.getId());
		entityManager.getTransaction().begin();
		editBook.setCode(book.getCode());
		editBook.setName(book.getName());
		entityManager.getTransaction().commit();

	}

	

}
