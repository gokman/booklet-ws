package com.fagose.booklet.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mvc.basic.model.Sample;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fagose.booklet.model.Book;
import com.fagose.booklet.model.BookLike;
import com.fagose.booklet.object.CustomBook;
import com.fagose.booklet.service.BookService;
import com.fagose.booklet.to.SearchCriteria;
import com.google.gson.Gson;


@Controller
@RequestMapping("/Book")
public class BookController{

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/GET/{name}", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBook(@PathVariable String name) throws IOException {
 
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setName(name);
		List<Book> bookList = bookService.listBook(searchCriteria);
		return bookList;
 
	}
	@RequestMapping(value="/LIST_COMMENTED_BOOKS/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<Book> listCommentedBooks(@PathVariable Long userId) throws IOException {
 
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setUserId(userId);
		List<Book> bookList = bookService.listCommentedBooks(searchCriteria);
		return bookList;
 
	}
	@RequestMapping(value="/GET_BY_ID/{bookId}", method = RequestMethod.GET)
	public @ResponseBody Book getBookById(@PathVariable Long bookId) throws IOException {
 
		Book book= bookService.getBookById(bookId);
		return book;
 
	}	
	@RequestMapping(value="/LIST_LIKES/{adderId}/{bookId}", method = RequestMethod.GET)
	@ResponseBody
	public List<BookLike> getBookLikes(@PathVariable("adderId") Long adderId,@PathVariable("bookId") Long bookId) throws IOException {
 
		SearchCriteria searchCriteria= new SearchCriteria();
		searchCriteria.setBookId(bookId);
		searchCriteria.setAdderId(adderId);
		List<BookLike> bookLikeList = bookService.listBookLike(searchCriteria);
		return bookLikeList;
 
	}
	
	
	@RequestMapping(value = "/LIST",method = RequestMethod.POST)
	@ResponseBody	
	public List<Book> listBooks(@RequestBody SearchCriteria searchCriteria) {
		List <Book> books = bookService.listBook(searchCriteria);
		
		return books;		
	}	
	
	@RequestMapping(value = "/CUSTOMLIST",method = RequestMethod.POST)
	@ResponseBody	
	public List<CustomBook> listCustomBooks(@RequestBody SearchCriteria searchCriteria) {
		List <Book> books = bookService.listBook(searchCriteria);
		List<CustomBook> customBooks=bookService.listCustomBook(books);
		return customBooks;		
	}	

	@RequestMapping(value = "/ADD", method = RequestMethod.POST)
	@ResponseBody
	public Book addBook(@RequestBody Book book) {

		bookService.addBook(book);
		
		return book;
	}	  
	  
	@RequestMapping(value = "/delete")
	public void delete(HttpServletRequest req,@ModelAttribute("book")Book book,BindingResult result) {
		bookService.deleteBook(book);
	}	
	
	@RequestMapping(value = "/COUNT/{userId}")
	public long countBookByUserId(@PathVariable Long userId) {
		return bookService.countBookByUserId(userId);
	}
	
}
