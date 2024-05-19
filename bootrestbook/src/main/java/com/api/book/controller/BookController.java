package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.services.BookService;

import entities.Book;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookservice.getAllBook();
	}
	@GetMapping("/books/{id}")
	public Book getBOOK(@PathVariable("id")int id)
	{
		return bookservice.getBookByID(id);
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b=this.bookservice.addBook(book);
		return b;
	}
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId")int bookId)
	{
		this.bookservice.deleteBook(bookId);
	}
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId) {
		this.bookservice.updateBook(book, bookId);
		return book;
	}
}
