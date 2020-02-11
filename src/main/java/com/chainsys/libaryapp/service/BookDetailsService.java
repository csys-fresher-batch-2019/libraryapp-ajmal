package com.chainsys.libaryapp.service;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.implementation.BookDetailsDAOImp;

public class BookDetailsService {

	private BookDetailsDAO bookDetailsDAO = new BookDetailsDAOImp();

	public void addNewBook(BookDetails bookdetails) throws Exception {
		bookDetailsDAO.addNewBook(bookdetails);
	}

	public void updateBookCopies(BookDetails bookdetails) throws Exception {

		bookDetailsDAO.updateBookCopies(bookdetails);
	}

	public BookDetails displayBook(int bookId) throws Exception {
		return bookDetailsDAO.displayBook(bookId);
	}

	public ArrayList<BookDetails> displayAllBooks() throws Exception {
		return bookDetailsDAO.displayAllBooks();
	}
}
