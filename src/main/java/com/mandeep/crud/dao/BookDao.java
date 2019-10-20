package com.mandeep.crud.dao;

import java.util.List;

import com.mandeep.crud.model.Books;

public interface BookDao {
	public void addBook(Books b);
	public void deleteBook(int bid);
	public void updateBook(Books b);
	public Books getById(int bid);
	public List<Books> getAllBooks();
}
	