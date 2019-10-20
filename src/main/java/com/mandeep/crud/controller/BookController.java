package com.mandeep.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mandeep.crud.dao.BookDao;
import com.mandeep.crud.model.Books;

@Controller
public class BookController {
	
	@Autowired
	private BookDao bdao;
	
	@RequestMapping(value = "/books")
	public String getBookForm(Model model) {
		model.addAttribute("books", new Books());
		return "BooksForm";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Books b, Model model) {
		bdao.addBook(b);
		model.addAttribute("blist", bdao.getAllBooks());
		return "home";
	}
	
	@RequestMapping(value = "/{bid}/delete", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("bid") int bid, Model model) {
		bdao.deleteBook(bid);
		model.addAttribute("blist", bdao.getAllBooks());
		return "home";
	}
	
	@RequestMapping(value = "/{bid}/edit", method = RequestMethod.GET)
	public String editBook(@PathVariable("bid") int bid, Model model) {
		model.addAttribute("books", bdao.getById(bid));
		return "EditBooks";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute Books b, Model model) {
		bdao.updateBook(b);
		model.addAttribute("blist", bdao.getAllBooks());
		return "home";
	}


}
