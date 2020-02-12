package com.chainsys.libraryapp.dao;

import java.util.ArrayList;

import com.chainsys.libraryapp.LibaryModel.BookDetails;
import com.chainsys.libraryapp.exception.DbException;

public interface BookDetailsDAO {
	 public void addNewBook(BookDetails bookdetails)throws DbException;
	 public void updateBookCopies(BookDetails bookdetails)throws DbException;
	 public BookDetails displayBook(int bookId)throws DbException;
	public ArrayList<BookDetails> displayAllBooks()throws DbException;
	public ArrayList<BookDetails> searchByName(String bookName) throws DbException;

}
