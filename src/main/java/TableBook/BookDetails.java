package TableBook;

import java.sql.Date;

public class BookDetails {
	public int bookId;
	public String bookName;
	public String bookCategory;
	public String bookAutherName;
	public int bookEdition;
	public int bookPrice;
	public Date bookPurchasedDate;
	public int bookCopies;
	public int bookPages;
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", bookCategory=" + bookCategory
				+ ", bookAutherName=" + bookAutherName + ", bookEdition=" + bookEdition + ", bookPrice=" + bookPrice
				+ ", bookPublishedDate=" + bookPurchasedDate + ", NoOfCopies=" + bookCopies + ", bookpages=" + bookPages
				+ "]";
	}
	
	}
	
	
	

