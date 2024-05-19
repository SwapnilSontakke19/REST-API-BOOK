package com.api.book.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import entities.Book;

import java.util.*;

@Component
public class BookService {
	private static List<Book> list = new ArrayList<>();
	static {
		list.add(new Book(12, "Java Reference", "XYZ"));
		list.add(new Book(13, "Python Reference", "ABC"));
		list.add(new Book(14, "Testing Reference", "EFG"));
	}

	// Get All Book
	public List<Book> getAllBook() {
		return list;

	}

	// Get Single Book By Id
	public Book getBookByID(int id) {
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;
	}

	// adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// Delete Book
	public void deleteBook(int bid) {
		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
	}

	// Update Book
	public void updateBook(Book book, int bookId) {
		list = list.stream().map(b -> {
			if (b.getId() == bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
