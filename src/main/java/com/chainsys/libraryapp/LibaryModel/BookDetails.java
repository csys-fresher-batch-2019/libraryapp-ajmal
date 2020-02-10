package com.chainsys.libraryapp.LibaryModel;

import java.sql.Date;

import lombok.Data;
@Data
public class BookDetails {
	private int bookId;
	private String bookName;
	private String bookCategory;
	private String bookAutherName;
	private int bookEdition;
	private int bookPrice;
	private Date bookPurchasedDate;
	private int bookCopies;
	private int bookPages;
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", bookCategory=" + bookCategory
				+ ", bookAutherName=" + bookAutherName + ", bookEdition=" + bookEdition + ", bookPrice=" + bookPrice
				+ ", bookPublishedDate=" + bookPurchasedDate + ", NoOfCopies=" + bookCopies + ", bookpages=" + bookPages
				+ "]";
	}
	
	}
	
	
	

