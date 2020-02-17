package com.chainsys.libraryapp.service;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.implementation.BookDetailsDAOImp;

public class BookDetailsService {

	private BookDetailsDAO bookDetailsDAO = new BookDetailsDAOImp();

	public void addNewBook(BookDetails bookdetails) throws Exception {
		bookDetailsDAO.addNewBook(bookdetails);
	}

	public void updateBookCopies(int bookId,int bookCopies) throws Exception {
		bookDetailsDAO.updateBookCopies(bookId, bookCopies);
	}

	public BookDetails displayBook(int bookId) throws Exception {
		return bookDetailsDAO.displayBook(bookId);
	}

	public ArrayList<BookDetails> displayAllBooks() throws Exception {
		return bookDetailsDAO.displayAllBooks();
	}
	public ArrayList<BookDetails> searchByName(String bookName) throws Exception{
		return bookDetailsDAO.searchByName(bookName);
		
	}
	
}
