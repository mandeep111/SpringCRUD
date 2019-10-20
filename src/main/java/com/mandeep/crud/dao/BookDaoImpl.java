package com.mandeep.crud.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mandeep.crud.model.Books;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Resource
	private SessionFactory sf;

	@Override
	@Transactional
	public void addBook(Books b) {
		Session s = sf.getCurrentSession();
		s.save(b);
		
	}

	@Override
	@Transactional
	public void deleteBook(int bid) {
		Session s = sf.getCurrentSession();
		Books b = (Books) s.get(Books.class, bid);
		s.delete(b);
		
	}

	@Override
	@Transactional
	public void updateBook(Books b) {
		Session s = sf.getCurrentSession();
		s.update(b);
	}

	@Override
	@Transactional
	public Books getById(int bid) {
		Session s = sf.getCurrentSession();
		Books b = (Books) s.get(Books.class, bid);
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Books> getAllBooks() {
		Session s = sf.getCurrentSession();
		Criteria crt = s.createCriteria(Books.class);
		List<Books> blist = crt.list();
		return blist;
	}
	
	

}
